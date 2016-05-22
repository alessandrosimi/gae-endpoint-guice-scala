package com.example.core.servlet

import javax.inject.Inject

import com.example.greeting.GreetingApi
import com.example.test.TestRunner
import com.google.inject.Injector
import org.junit.Assert._
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(classOf[TestRunner])
class ServletTest @Inject()(injector: Injector, greetingApi: GreetingApi) {
  @Test
  def testTheServletCreationAndInitWithServices() {
    val servlet = new InjectedSystemServiceServlet
    InjectedSystemServiceServlet.injector = Some(injector)
    servlet.init(new ServletConfigurationTest.ActualServletConfig)
    assertEquals(greetingApi, servlet.createService(classOf[GreetingApi]))
  }

}
