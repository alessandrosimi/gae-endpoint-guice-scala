package com.example.core.datastore

import com.google.appengine.api.datastore.{DatastoreService, DatastoreServiceFactory}
import com.google.inject.{AbstractModule, Provides}

private[core] object DataStoreModule extends AbstractModule{

  def configure() {}

  @Provides
  def dataStoreProviders: DatastoreService = DatastoreServiceFactory.getDatastoreService

}
