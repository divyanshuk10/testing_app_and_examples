package com.example.mytestingapp.domain

class Calculator {

  fun add(op1: Int, op2: Int): Int {
    return op1 + op2
  }

  fun diff(op1: Int, op2: Int): Int {
    return op1 - op2
  }

  fun mul(op1: Int, op2: Int): Int {
    return op1 * op2
  }

  fun div(op1: Int, op2: Int): Int {
    return (op1 / op2)
  }
}