package com.example.mytestingapp.mockk

import io.mockk.*
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class ExampleClassWithPrivateMethodTest {
  @Before
  fun setUp() {
    MockKAnnotations.init(this, relaxed = true)
  }


  @Test
  fun `test private functions`() {
    val mock = spyk<ExampleClassWithPrivateMethod>(recordPrivateCalls = true)
    // telling mockk that if a private function is invoked then return something
    every { mock["printHelloInPrivate"]() } returns "Hello in PRIVATE"

    //
    Assert.assertEquals("Hello in PRIVATE", mock.printHello())

    verifySequence {
      mock.printHello()
      mock["printHelloInPrivate"]()
    }

  }

  @After
  fun afterTests() {
    unmockkAll()
  }

}