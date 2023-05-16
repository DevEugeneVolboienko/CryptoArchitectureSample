package com.example.architectureexample

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.architectureexample.domain.usecase.GetCryptoUseCase
import com.example.architectureexample.presentation.ui.crypto_list.router.CryptoListRouter
import com.example.architectureexample.presentation.ui.crypto_list.viewmodel.CryptoViewModel
import com.example.architectureexample.presentation.ui.main.MainViewModel
import io.reactivex.Single
import org.junit.*
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations

class MainViewModelTest {
    @get:Rule
    val taskExecutorRule = InstantTaskExecutorRule()
    @get:Rule
    val schedulers = RxImmediateSchedulerRule()

    @Mock
    lateinit var getCryptoUseCase: GetCryptoUseCase
    @Mock
    lateinit var cryptoListRouter: CryptoListRouter
    @Mock
    lateinit var mockLiveDataObserver: Observer<List<CryptoViewModel>>

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @After
    fun tearDown() {
        MockitoAnnotations.openMocks(this).close()
    }

    @Test
    fun `Given getCryptoList returns data then update live data`() {
        val mockData = listOf(CryptoViewModel().apply {
            id.set("id")
            name.set("name")
            symbol.set("symbol")
        })
        `when`(getCryptoUseCase.getCryptoList()).thenReturn(Single.just(mockData))
        val mainViewModel = MainViewModel(getCryptoUseCase, cryptoListRouter)
        mainViewModel.loadCryptoList()

        Assert.assertEquals(mockData, mainViewModel.cryptoList.value)
    }

    @Test
    fun `Given getCryptoList returns error then don't change live data`() {
        `when`(getCryptoUseCase.getCryptoList()).thenReturn(Single.error(Throwable()))
        val mainViewModel = MainViewModel(getCryptoUseCase, cryptoListRouter)
        mainViewModel.cryptoList.observeForever(mockLiveDataObserver)
        mainViewModel.loadCryptoList()

        Assert.assertNull(mainViewModel.cryptoList.value)
        verify(mockLiveDataObserver, times(0)).onChanged(any())
    }
}