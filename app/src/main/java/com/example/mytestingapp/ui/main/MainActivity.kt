package com.example.mytestingapp.ui.main

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.mytestingapp.R
import com.example.mytestingapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

  private val TAG: String = this::class.java.name
  private var viewModel: MainActivityViewModel? = null
  private var binding: ActivityMainBinding? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    binding?.viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]
    binding?.lifecycleOwner = this
    viewModel = binding?.viewModel
  }

  override fun onClick(view: View?) {
    when (view?.id) {
      R.id.btn_calculate -> {
        if (binding?.etValue1?.text.isNullOrBlank() || binding?.etValue2?.text.isNullOrBlank()) {
          Toast.makeText(this, "Please enter both values", Toast.LENGTH_SHORT).show()
          return
        }
        binding?.etValue1.let {
          viewModel?.num1?.value = it?.text.toString().toInt()
        }
        binding?.etValue2.let {
          viewModel?.num2?.value = it?.text.toString().toInt()
        }

        when (viewModel?.operation) {
          MainActivityViewModel.Operation.ADDITION -> {
            Toast.makeText(this, "Addition", Toast.LENGTH_SHORT).show()
            binding?.tvResult?.text = viewModel?.calculate().toString()
          }
          MainActivityViewModel.Operation.SUBTRACT -> {
            Toast.makeText(this, "Subtraction", Toast.LENGTH_SHORT).show()
            binding?.tvResult?.text = viewModel?.calculate().toString()
          }
          MainActivityViewModel.Operation.MULTIPLICATION -> {
            Toast.makeText(this, "Multiplication", Toast.LENGTH_SHORT).show()
            binding?.tvResult?.text = viewModel?.calculate().toString()
          }
          MainActivityViewModel.Operation.DIVISION -> {
            Toast.makeText(this, "Division", Toast.LENGTH_SHORT).show()
            binding?.tvResult?.text = viewModel?.calculate().toString()
          }
          else -> {
            Toast.makeText(this, "No operation to perform", Toast.LENGTH_SHORT).show()
          }
        }
      }
    }
  }

}