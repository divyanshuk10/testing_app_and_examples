package com.example.mytestingapp.testdoubles.stub

import com.example.mytestingapp.testdouble.stub.Book
import com.example.mytestingapp.testdouble.stub.BookRepository
import com.example.mytestingapp.testdouble.stub.BookViewModel
import org.junit.Assert
import org.junit.Test
import org.mockito.Mockito
import java.time.LocalDate

class StubTest {

  @Test
  fun `test stub`() {
    val bookRepository: BookRepository = BookRepositoryStub()
    // provides predefined answers to method executions made during the test, instead of calling external services
    // provides hard coded behaviour
    val bookViewModel = BookViewModel(bookRepository)

    val discountedBooks = bookViewModel.getNewBooksWithAppliedDiscount(10, 7)

    Assert.assertEquals("Books not added", 2, discountedBooks?.size)
    Assert.assertEquals("Books not added", 450, discountedBooks?.first()?.price)
    Assert.assertEquals("Books not added", 360, discountedBooks?.last()?.price)
  }

  @Test
  fun `test stub with Mockito`() {
    val bookRepository: BookRepository = Mockito.mock(BookRepository::class.java)
    val bookViewModel = BookViewModel(bookRepository)

    Mockito.`when`(bookRepository.findNewBooks(7)).thenReturn(listOf(
      Book("1234", "Title 1", 500, LocalDate.now()),
      Book("123", "Title 2", 400, LocalDate.now()),
    ))

    val discountedBooks = bookViewModel.getNewBooksWithAppliedDiscount(10, 7)

    Assert.assertEquals("Books not added", 2, discountedBooks?.size)
    Assert.assertEquals("Books not added", 450, discountedBooks?.first()?.price)
    Assert.assertEquals("Books not added", 360, discountedBooks?.last()?.price)
  }

}