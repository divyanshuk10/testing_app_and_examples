package com.example.mytestingapp.testdoubles.spy

import com.example.mytestingapp.testdouble.spy.Book
import com.example.mytestingapp.testdouble.spy.BookRepository
import com.example.mytestingapp.testdouble.spy.BookViewModel
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import org.mockito.Mockito
import java.time.LocalDate


class SpyTest {

  @Test
  fun demoSpy() {
    val bookRepositorySpy = BookRepositorySpy()
    // similar to stub , additionally they records info about how they were executed
    val bookViewModel = BookViewModel(bookRepositorySpy)

    val book1 = Book("1234", "Title 1", 300, LocalDate.now())
    val book2 = Book("1235", "Title 2", 250, LocalDate.now())
    val book3 = Book("1235", "Title 2", 401, LocalDate.now())

    bookViewModel.addBook(book1)
    bookViewModel.addBook(book2)
    bookViewModel.addBook(book3)

    assertEquals(2, bookRepositorySpy.timesCalled())
    assertTrue(bookRepositorySpy.calledWith(book2))
  }

  @Test
  fun `demo spy using Mockito`() {
    val bookRepositorySpy = BookRepositorySpy()
    val bookViewModel = BookViewModel(bookRepositorySpy)

    val book1 = Book("1234", "Title 1", 300, LocalDate.now())
    val book2 = Book("1235", "Title 2", 250, LocalDate.now())
    val book3 = Book("1235", "Title 2", 401, LocalDate.now())

    bookViewModel.addBook(book1)
    bookViewModel.addBook(book2)
    bookViewModel.addBook(book3)

    assertEquals(2, bookRepositorySpy.timesCalled())
    assertTrue(bookRepositorySpy.calledWith(book2))
  }

  @Test
  fun `demo mock with Mockito`() {
    val bookRepositorySpy = Mockito.spy(BookRepository::class.java)
    val bookViewModel = BookViewModel(bookRepositorySpy)

    val book1 = Book("1234", "Title 1", 500, LocalDate.now())
    val book2 = Book("1235", "Title 2", 250, LocalDate.now())

    bookViewModel.addBook(book1)
    bookViewModel.addBook(book2)

    Mockito.verify(bookRepositorySpy, Mockito.times(0)).save(book1)
    Mockito.verify(bookRepositorySpy, Mockito.times(1)).save(book2)
  }

}