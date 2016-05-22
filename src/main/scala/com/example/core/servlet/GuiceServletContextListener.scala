package com.example.core.servlet

/**
  * Extends the Google servlet to provide a custom injector.
  */
class GuiceServletContextListener extends com.google.inject.servlet.GuiceServletContextListener {
  protected[servlet] def getInjector = InjectedSystemServiceServlet.getOrCreateInjector
}
