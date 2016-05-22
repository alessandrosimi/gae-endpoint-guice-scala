package com.example.core

import com.example.core.datastore.DataStoreModule
import com.example.core.servlet.ServletModule
import com.google.inject.AbstractModule

object CoreModule extends AbstractModule {
  def configure() {
    install(DataStoreModule)
    install(ServletModule)
  }
}
