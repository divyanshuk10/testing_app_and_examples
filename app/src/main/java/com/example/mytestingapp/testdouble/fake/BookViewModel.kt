package com.example.mytestingapp.testdouble.fake

import androidx.lifecycle.ViewModel

class BookViewModel(
  private val bookRepository: BookRepository,
) : ViewModel() {
  fun addBook(book: Book?) {
    bookRepository.save(book)
  }

  fun findNumberOfBooks(): Int {
    return bookRepository.findAll()!!.size
  }
}