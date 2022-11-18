package com.example.mytestingapp.testdoubles.fake

import com.example.mytestingapp.testdouble.fake.Book
import com.example.mytestingapp.testdouble.fake.BookRepository


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