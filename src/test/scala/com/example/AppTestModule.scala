package com.example

import com.example.core.CoreTestModule
import com.google.inject.util.Modules.`override`
import com.google.inject.{AbstractModule, Guice, Injector}

class AppTestModule extends AbstractModule {
  def configure() {
    install(`override`(new AppModule).`with`(new CoreTestModule))
  }
}

object AppTestModule {
  val injector: Injector = Guice.createInjector(new AppTestModule)
}
