package com.example.mytestingapp.testdoubles.stub

import com.example.mytestingapp.testdouble.stub.Book
import com.example.mytestingapp.testdouble.stub.BookRepository
import java.time.LocalDate

class BookRepositoryStub : BookRepository {

  // hardcoded new books
  override fun findNewBooks(days: Int): List<Book?>? = listOf(
    Book("1234", "Title 1", 500, LocalDate.now()),
    Book("123", "Title 2", 400, LocalDate.now()),
  )
}
