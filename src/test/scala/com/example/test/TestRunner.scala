package com.example.test

import java.util

import com.example.AppTestModule
import org.junit.runners.BlockJUnit4ClassRunner

class TestRunner(testClass: Class[_]) extends BlockJUnit4ClassRunner(testClass) {

  override def createTest(): AnyRef =
    AppTestModule.injector.getInstance(testClass).asInstanceOf[AnyRef]

  override def validateZeroArgConstructor(errors: util.List[Throwable]): Unit = {}

}
