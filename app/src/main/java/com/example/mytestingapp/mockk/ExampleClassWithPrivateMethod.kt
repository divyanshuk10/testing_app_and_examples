package com.example.mytestingapp.mockk

class ExampleClassWithPrivateMethod {

  fun printHello(): String {
    return printHelloInPrivate()
  }

  private fun printHelloInPrivate() = "Hello private"
}