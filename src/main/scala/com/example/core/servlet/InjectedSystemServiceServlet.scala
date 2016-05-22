package com.example.core.servlet

import javax.servlet.ServletConfig

import com.example.AppModule
import com.example.core.servlet.InjectedSystemServiceServlet._
import com.google.api.server.spi.SystemServiceServlet
import com.google.inject.{Guice, Injector}
import org.slf4j.{Logger, LoggerFactory}

class InjectedSystemServiceServlet extends SystemServiceServlet {

  private val logger: Logger = LoggerFactory.getLogger(classOf[InjectedSystemServiceServlet])

  logger.info("Create the service servlet with the injector")

  override def init(config: ServletConfig) {
    super.init(new InjectedServletConfig(config, getOrCreateInjector))
  }

  protected[servlet] override def createService[T](serviceClass: Class[T]): T = {
    logger.info("Create service " + serviceClass.getSimpleName)
    getOrCreateInjector.getInstance(serviceClass)
  }

}

object InjectedSystemServiceServlet {

  private[servlet] var injector: Option[Injector] = None

  def getOrCreateInjector: Injector = synchronized {
    injector.getOrElse {
      val result = Guice.createInjector(new AppModule)
      injector = Some(result)
      result
    }
  }

}
