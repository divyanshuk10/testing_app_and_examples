package com.example.mytestingapp.testdouble.mock

class BookViewModel(private val bookRepository: BookRepository) {
  fun addBook(book: Book) {
    if (book.price > 400) {
      return
    }
    bookRepository.save(book)
  }
}