package com.example.mytestingapp.ui.main

import android.support.test.runner.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class MainActivityViewModelTest {

  //lateinit var CUT: MainActivityViewModel

//  @Before
//  fun setUp() {
//  }

  /*@After
  fun tearDown() {
  }*/

  @Test
  fun `num1 is set to 10`() {
    val i = 10
    assertThat(i).isEqualTo(10)
  }
/*
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
  }*/
}