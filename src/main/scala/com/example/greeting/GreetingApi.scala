package com.example.greeting

import javax.inject.Inject

import com.google.api.server.spi.config.ApiMethod.HttpMethod._
import com.google.api.server.spi.config.{ApiMethod, Api}
import com.google.appengine.api.datastore.DatastoreService

@Api(
  name = "greeting",
  version = "v1"
)
class GreetingApi @Inject() (datastoreService: DatastoreService) {

  @ApiMethod(httpMethod = GET)
  def hello(): GreetingDto = {
    val name = "stranger"
    val dto = new GreetingDto
    dto.setText(s"Hello $name!")
    dto
  }

}
