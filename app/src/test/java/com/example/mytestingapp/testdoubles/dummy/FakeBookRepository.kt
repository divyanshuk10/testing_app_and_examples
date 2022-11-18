package com.example.mytestingapp.testdoubles.dummy

import com.example.mytestingapp.testdouble.dummy.Book
import com.example.mytestingapp.testdouble.dummy.BookRepository


class FakeBookRepository : BookRepository {
  // In memory database, HashMap or List
  var bookStore = HashMap<String, Book>()

  override fun save(book: Book?) {
    bookStore[book!!.bookId] = book
  }

  override fun findAll(): Collection<Book> {
    return bookStore.values
  }
}