package com.example.core.servlet

import javax.servlet.ServletConfig

import com.example.core.servlet.InjectedServletConfig._
import com.google.api.server.spi.config.Api
import com.google.inject.{Injector, Key}

import scala.collection.JavaConverters._

/**
  * Wraps a service configuration and overriding the "service"
  * parameter with a list of classes name taken from the Guice
  * context. In this way the each endpoint is automatically loaded
  * when the server start up.
  * To enable this the endpoint class should be annotated with
  * [[Api]] and bound in a Guice module.
  */
private[servlet] class InjectedServletConfig(config: ServletConfig,
                                             injector: Injector) extends ServletConfig {

  private val services = getBoundServices(injector)

  def getServletName = config.getServletName

  def getServletContext = config.getServletContext

  def getInitParameter(name: String) =
    if (Services == name) services else config.getInitParameter(name)

  def getInitParameterNames = config.getInitParameterNames

}

object InjectedServletConfig {

  private[servlet] val Services = "services"

  private def getBoundServices(injector: Injector) = {
    injector.getBindings.keySet().asScala
      .map(toRawType)
      .filter(apiClass)
      .map(_.getName)
      .mkString(",")
  }

  private def toRawType(key: Key[_]) = key.getTypeLiteral.getRawType

  private def apiClass(clazz: Class[_]) = clazz.isAnnotationPresent(classOf[Api])

}
