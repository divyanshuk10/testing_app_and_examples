package com.example.mytestingapp.testdouble.spy

import androidx.lifecycle.ViewModel

class BookViewModel(private val bookRepository: BookRepository) : ViewModel() {

  fun addBook(book: Book) {
    if (book.price > 400) {
      return
    }
    bookRepository.save(book)
  }
}