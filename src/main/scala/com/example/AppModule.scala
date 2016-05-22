package com.example

import com.example.core.CoreModule
import com.example.greeting.GreetingModule
import com.google.inject.AbstractModule

class AppModule extends AbstractModule {
  def configure() {
    install(CoreModule)
    install(GreetingModule)
  }
}
