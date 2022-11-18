package com.example.mytestingapp.testdoubles.mock

import com.example.mytestingapp.testdouble.mock.Book
import com.example.mytestingapp.testdouble.mock.BookRepository
import org.junit.Assert

class BookRepositoryMock : BookRepository {
  var saveCalled = 0
  var lastAddedBook: Book? = null

  override fun save(book: Book?) {
    saveCalled++
    lastAddedBook = book
  }

  fun verify(book: Book?, times: Int) {
    Assert.assertEquals(times, saveCalled)
    Assert.assertEquals(book, lastAddedBook)
  }
}