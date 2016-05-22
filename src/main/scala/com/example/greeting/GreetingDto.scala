package com.example.greeting

import scala.beans.BeanProperty

class GreetingDto(@BeanProperty var text: String) {

  def this() = this(null)

}
