package com.example.mytestingapp.main


import androidx.lifecycle.MutableLiveData
import com.example.mytestingapp.ui.main.MainActivityViewModel
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Ignore
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito.given
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MainActivityViewModelTest {

  @Mock
  private lateinit var CUT: MainActivityViewModel

  @Before
  fun setUp() {
    MockitoAnnotations.openMocks(this)

  }

  @Ignore
  @Test
  fun `do ADDITION of 10 + 5`() {
    //given(CUT.operation).willReturn(MainActivityViewModel.Operation.ADDITION)
    given(CUT.num1).willReturn(MutableLiveData(10))
    given(CUT.num2).willReturn(MutableLiveData(5))


    `when`(CUT.operation).thenReturn(MainActivityViewModel.Operation.ADDITION)
    `when`(CUT.num1.value!!).thenReturn(10)
    `when`(CUT.num2.value!!).thenReturn(5)

    CUT.calculate()
    assertThat(CUT.result).isEqualTo(15)
  }


}
