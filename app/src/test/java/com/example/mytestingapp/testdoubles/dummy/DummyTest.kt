package com.example.mytestingapp.testdoubles.dummy

import com.example.mytestingapp.testdouble.dummy.Book
import com.example.mytestingapp.testdouble.dummy.BookRepository
import com.example.mytestingapp.testdouble.dummy.BookViewModel
import com.example.mytestingapp.testdouble.dummy.EmailService
import org.junit.Assert
import org.junit.Test
import org.mockito.Mockito
import java.time.LocalDate

class DummyTest {

  @Test
  fun `test dummy`() {
    val bookRepository: BookRepository = FakeBookRepository()
    val emailService: EmailService = DummyEmailService()
    // passed just to make the code compile
    val bookViewModel = BookViewModel(bookRepository, emailService)

    bookViewModel.addBook(Book("1234", "Title 1", 250, LocalDate.now()))
    bookViewModel.addBook(Book("123", "Title 2", 200, LocalDate.now()))

    Assert.assertEquals("Books not added", 2, bookViewModel.findNumberOfBooks())
  }

  @Test
  fun `test dummy with Mockito`() {
    val bookRepository = Mockito.mock(BookRepository::class.java)
    val emailService = Mockito.mock(EmailService::class.java)
    val bookViewModel = BookViewModel(bookRepository, emailService)

    Mockito.`when`(bookRepository.findAll()).thenReturn(
      listOf(
        Book("1234", "Title 1", 250, LocalDate.now()),
        Book("1494", "Title 2", 350, LocalDate.now())
      )
    )

    Mockito.`when`(emailService.sendEmail("Some message")).then { }
    Assert.assertEquals(2, bookViewModel.findNumberOfBooks())
  }

}