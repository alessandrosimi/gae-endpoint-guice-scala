package com.example.greeting

import javax.inject.Inject

import com.example.test.AbstractTest
import org.junit.Assert._
import org.junit.Test

class GreetingTest @Inject() (greetingApi: GreetingApi) extends AbstractTest {

  @Test
  def theGreetingShouldSayHi(): Unit = {
    val dto = greetingApi.hello()
    assertTrue("The result should contains hello", dto.getText.toLowerCase.contains("hello"))
  }

}
