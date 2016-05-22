package com.example.core.servlet

private[core] object ServletModule extends com.google.inject.servlet.ServletModule {
  override def configureServlets() {
    // Add here the extra url to serve
  }
}
