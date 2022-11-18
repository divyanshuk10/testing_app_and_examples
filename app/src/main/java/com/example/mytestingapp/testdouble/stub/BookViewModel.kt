package com.example.mytestingapp.testdouble.stub

import androidx.lifecycle.ViewModel


class BookViewModel(private val bookRepository: BookRepository) : ViewModel() {

  fun getNewBooksWithAppliedDiscount(discountRate: Int, days: Int): List<Book?>? {
    val newBooks = bookRepository.findNewBooks(days)
    // 500 apply 10% -> 10% of 500 -> 50 -> 500 - 50 -> 450
    // 400 apply 10% -> 10% of 400 -> 50 -> 400 - 40 -> 360
    for (book in newBooks!!) {
      val price = book!!.price
      val newPrice = price - discountRate * price / 100
      book.price = newPrice
    }
    return newBooks
  }
}