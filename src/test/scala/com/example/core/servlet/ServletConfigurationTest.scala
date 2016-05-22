package com.example.core.servlet

import java.util
import javax.inject.Inject
import javax.servlet.{ServletConfig, ServletContext}

import com.example.core.servlet.ServletConfigurationTest.ActualServletConfig
import com.example.greeting.GreetingApi
import com.example.test.TestRunner
import com.google.inject.Injector
import org.junit.Assert._
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import com.example.core.servlet.InjectedServletConfig.Services

@RunWith(classOf[TestRunner])
class ServletConfigurationTest @Inject() (injector: Injector) {

  @Test
  def testTheServletConfiguration() {
    val expected = new ActualServletConfig
    val actual: ServletConfig = new InjectedServletConfig(expected, injector)
    assertEquals(expected.getServletName, actual.getServletName)
    val expectedEnum: util.Enumeration[_] = expected.getInitParameterNames
    val actualEnum: util.Enumeration[_] = actual.getInitParameterNames
    assertEquals(expectedEnum.nextElement, actualEnum.nextElement)
    assertEquals(expectedEnum.nextElement, actualEnum.nextElement)
    assertEquals(expectedEnum.hasMoreElements, actualEnum.hasMoreElements)
    assertFalse(expected.getInitParameter(Services) == actual.getInitParameter(Services))
    assertListOfServices(actual.getInitParameter(Services))
    assertEquals(expected.getServletContext, actual.getServletContext)
  }

  private def assertListOfServices(actual: String) {
    val expectedServices = List(classOf[GreetingApi].getName).sorted
    val actualServices = actual.split(",").toList.sorted
    assertEquals("The service list should be the same", expectedServices, actualServices)
  }
}

object ServletConfigurationTest {

  private val ParamName = "ParamName"

  class ActualServletConfig extends ServletConfig {

    private val servletContext = Mockito.mock(classOf[ServletContext])
    private val initParameters = Map(ParamName -> "paramValue", Services -> "notAService")

    def getInitParameterNames: util.Enumeration[Any] = new util.Enumeration[Any] {
      private val iterator = initParameters.iterator
      def hasMoreElements: Boolean = iterator.hasNext
      def nextElement(): Any = iterator.next()
    }

    def getServletName: String = "servletName"

    def getInitParameter(name: String): String = initParameters.get(name).orNull

    def getServletContext: ServletContext = servletContext
  }

}
