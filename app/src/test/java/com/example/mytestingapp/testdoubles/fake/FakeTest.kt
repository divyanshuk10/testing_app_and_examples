package com.example.mytestingapp.testdoubles.fake

import com.example.mytestingapp.testdouble.fake.Book
import com.example.mytestingapp.testdouble.fake.BookRepository
import com.example.mytestingapp.testdouble.fake.BookViewModel
import org.junit.Assert
import org.junit.Test
import org.mockito.Mockito
import java.time.LocalDate

class FakeTest {

  @Test
  fun `test fake`() {
    val bookRepository: BookRepository = FakeBookRepository()
    // using fake data repository like arraylist or hash map
    val bookViewModel = BookViewModel(bookRepository)

    bookViewModel.addBook(Book("1234", "Title 1", 250, LocalDate.now()))
    bookViewModel.addBook(Book("123", "Title 2", 200, LocalDate.now()))

    Assert.assertEquals("Books not added", 2, bookViewModel.findNumberOfBooks())
  }

  @Test
  fun `test fake with Mockito`() {
    val bookRepository = Mockito.mock(BookRepository::class.java)
    val bookViewModel = BookViewModel(bookRepository)

    val bookList = listOf(
      Book("1234", "Title 1", 250, LocalDate.now()),
      Book("123", "Title 2", 200, LocalDate.now()),
      Book("123", "Title 2", 401, LocalDate.now()),
    )

    Mockito.`when`(bookRepository.findAll()).thenReturn(bookList)

    Assert.assertEquals("Books not added", 3, bookViewModel.findNumberOfBooks())

  }
}