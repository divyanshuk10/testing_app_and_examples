package com.example.mytestingapp.testdoubles.mock

import com.example.mytestingapp.testdouble.mock.Book
import com.example.mytestingapp.testdouble.mock.BookRepository
import com.example.mytestingapp.testdouble.mock.BookViewModel
import org.junit.Before
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import java.time.LocalDate

//@RunWith(MockitoJUnitRunner::class)
class MockTest {

  @InjectMocks
  lateinit var bookViewModel: BookViewModel

  @Mock
  lateinit var bookRepositoryMock: BookRepository

  @Before
  fun before() {
    MockitoAnnotations.openMocks(this)
  }


  @Test
  fun `demo mock`() {
    val bookRepositoryMock = BookRepositoryMock()
    //
    val bookViewModel = BookViewModel(bookRepositoryMock)

    val book1 = Book("1234", "Title 1", 300, LocalDate.now())
    val book2 = Book("1235", "Title 2", 250, LocalDate.now())
    val book3 = Book("1235", "Title 2", 401, LocalDate.now())

    bookViewModel.addBook(book1)
    bookViewModel.addBook(book2)
    bookViewModel.addBook(book3)

    bookRepositoryMock.verify(book2, 2)
  }

  @Test
  fun `demo mock with Mockito`() {
    val book1 = Book("1234", "Title 1", 500, LocalDate.now())
    val book2 = Book("1235", "Title 2", 250, LocalDate.now())

    bookViewModel.addBook(book1)
    bookViewModel.addBook(book2)

    Mockito.verify(bookRepositoryMock, Mockito.times(0)).save(book1)
    Mockito.verify(bookRepositoryMock, Mockito.times(1)).save(book2)
  }

}