package com.example.mytestingapp.testdoubles.dummy

import com.example.mytestingapp.testdouble.dummy.EmailService

class DummyEmailService : EmailService {
  override fun sendEmail(message: String?) {
    throw AssertionError("Method not implemented")
  }
}