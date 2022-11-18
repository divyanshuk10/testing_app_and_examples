package com.example.mytestingapp.testdoubles.spy

import com.example.mytestingapp.testdouble.spy.Book
import com.example.mytestingapp.testdouble.spy.BookRepository

class BookRepositorySpy : BookRepository {
  var saveCalled = 0
  var lastAddedBook: Book? = null

  override fun save(book: Book?) {
    saveCalled++
    lastAddedBook = book
  }

  fun timesCalled(): Int {
    return saveCalled
  }

  fun calledWith(book: Book?): Boolean {
    return lastAddedBook!! == book
  }
}