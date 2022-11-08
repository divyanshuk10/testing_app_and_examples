package com.example.mytestingapp.ui.main

import org.junit.After
import org.junit.Before
import org.junit.Test

class MainActivityViewModelTest {

  lateinit var CUT: MainActivityViewModel

  @Before
  fun setUp() {
    CUT = MainActivityViewModel()
  }

  @After
  fun tearDown() {
  }

  @Test
  fun getNum1() {
    CUT.num1.value = 10

  }

  @Test
  fun getNum2() {
  }

  @Test
  fun getResult() {
  }

  @Test
  fun getOperation() {
  }

  @Test
  fun acceptOperation() {
  }

  @Test
  fun calculate() {
  }
}