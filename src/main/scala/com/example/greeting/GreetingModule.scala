package com.example.greeting

import com.google.inject.{Scopes, AbstractModule}

object GreetingModule extends AbstractModule {

  def configure() {
    bind(classOf[GreetingApi]).in(Scopes.SINGLETON)
  }

}
