package com.example.mytestingapp.testdouble.dummy


interface BookRepository {
  fun save(book: Book?)
  fun findAll(): Collection<Book?>?
}