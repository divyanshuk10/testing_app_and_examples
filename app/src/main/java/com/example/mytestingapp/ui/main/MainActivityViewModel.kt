package com.example.mytestingapp.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mytestingapp.domain.Calculator

class MainActivityViewModel : ViewModel() {

  val num1 = MutableLiveData<Int>()
  val num2 = MutableLiveData<Int>()

  lateinit var calculator: Calculator

  init {
    num1.value = 0
    num2.value = 0
    calculator = Calculator()
  }

  var result = 0
  var operation = Operation.NONE

  fun acceptOperation(operation: Operation) {
    this@MainActivityViewModel.operation = operation
  }

  fun calculate(): Int {
    result = when (operation) {
      Operation.ADDITION -> {
        calculator.add(num1.value!!, num2.value!!)
      }
      Operation.SUBTRACT -> {
        calculator.diff(num1.value!!, num2.value!!)
      }
      Operation.MULTIPLICATION -> {
        calculator.mul(num1.value!!, num2.value!!)
      }
      Operation.DIVISION -> {
        calculator.div(num1.value!!, num2.value!!)
      }
      else -> {
        0
      }
    }
    return result
  }

  enum class Operation {
    ADDITION, SUBTRACT, MULTIPLICATION, DIVISION, NONE
  }
}

