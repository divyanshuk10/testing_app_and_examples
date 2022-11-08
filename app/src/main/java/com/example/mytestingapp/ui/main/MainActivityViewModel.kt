package com.example.mytestingapp.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {

  val num1 = MutableLiveData<Int>()
  val num2 = MutableLiveData<Int>()

  init {
    num1.value = 0
    num2.value = 0
  }

  private var _result = 0
  val result: Int
    get() = _result
  private var _operation = Operation.NONE
  val operation: Operation
    get() = _operation

  fun acceptOperation(operation: Operation) {
    _operation = operation
  }

  fun calculate(): Int {
    _result = when (_operation) {
      Operation.ADDITION -> {
        sum(num1.value!!, num2.value!!)
      }
      Operation.SUBTRACT -> {
        subtract(num1.value!!, num2.value!!)
      }
      Operation.MULTIPLICATION -> {
        multiply(num1.value!!, num2.value!!)
      }
      Operation.DIVISION -> {
        divide(num1.value!!, num2.value!!)
      }
      else -> {
        0
      }
    }
    return result
  }

  private fun sum(a: Int, b: Int): Int {
    return a + b
  }

  private fun subtract(a: Int, b: Int): Int {
    return a - b
  }

  private fun multiply(a: Int, b: Int): Int {
    return a * b
  }

  private fun divide(a: Int, b: Int): Int {
    return a / b
  }

  enum class Operation {
    ADDITION, SUBTRACT, MULTIPLICATION, DIVISION, NONE
  }
}

