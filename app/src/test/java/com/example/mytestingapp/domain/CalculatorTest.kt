package com.example.mytestingapp.domain

import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class CalculatorTest {

  private var calculator: Calculator? = null


  @Before
  fun setup() {
    calculator = Calculator()
  }

  @After
  fun tearDown() {
    calculator = null
  }

  @Test
  fun add() {
    val total = calculator!!.add(4, 5)
    assertEquals("Calculator is not adding correctly", 9, total)
  }

  @Test
  fun diff() {
    val total = calculator!!.diff(9, 2)
    assertEquals("Calculator is not subtracting correctly", 7, total)
  }

  @Test
  fun mul() {
    val total = calculator!!.mul(9, 3)
    assertEquals("Calculator is not multiplying correctly", 27, total)
  }

  @Test
  fun div() {
    val total = calculator!!.div(9, 3)
    assertEquals("Calculator is not dividing correctly", 3, total)
  }

  @Test(expected = ArithmeticException::class)
  fun testDivWithZeroDivisor() {
    calculator = Calculator()
    val total = calculator!!.div(0, 0)
    assertEquals(0, total)
  }

  /*@Ignore
  @Test(expected = ArithmeticException::class)
  fun test_divide_with_zero() {
    calculator = Calculator()
    val total = calculator!!.div(0, 0)
    assertEquals(0, total)
  }*/
}