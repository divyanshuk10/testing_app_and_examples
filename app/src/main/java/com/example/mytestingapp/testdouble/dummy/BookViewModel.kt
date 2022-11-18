package com.example.mytestingapp.testdouble.dummy

import androidx.lifecycle.ViewModel

class BookViewModel(
  private val bookRepository: BookRepository,
  private val emailService: EmailService
) : ViewModel() {
  fun addBook(book: Book?) {
    bookRepository.save(book)
  }

  fun findNumberOfBooks(): Int {
    return bookRepository.findAll()!!.size
  } // Other methods which use E  mailService
}