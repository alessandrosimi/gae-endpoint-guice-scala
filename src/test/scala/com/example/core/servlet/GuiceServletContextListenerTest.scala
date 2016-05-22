package com.example.core.servlet

import org.junit.Assert._
import org.junit.Test

class GuiceServletContextListenerTest {

  @Test
  def theServletContextListenerShouldBeAbleToGenerateTheInjector() {
    assertNotNull("The injector should not be null", new GuiceServletContextListener().getInjector)
  }

}
