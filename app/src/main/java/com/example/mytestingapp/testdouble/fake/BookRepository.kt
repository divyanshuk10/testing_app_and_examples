package com.example.mytestingapp.testdouble.fake


interface BookRepository {
  fun save(book: Book?)
  fun findAll(): Collection<Book?>?
}