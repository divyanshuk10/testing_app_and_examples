package com.example.mytestingapp.testdouble.stub


interface BookRepository {
  fun findNewBooks(days: Int): List<Book?>?
}