package com.example.architectureexample.presentation.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.architectureexample.data.TIMBER_MSG_SUCCESS_GET_CRYPTO_LIST
import com.example.architectureexample.domain.usecase.GetCryptoUseCase
import com.example.architectureexample.presentation.di.scope.ActivityScope
import com.example.architectureexample.presentation.ui.base.BaseViewModel
import com.example.architectureexample.presentation.ui.base.listener.OnItemClickListener
import com.example.architectureexample.presentation.ui.crypto_list.adapter.CryptoListAdapter
import com.example.architectureexample.presentation.ui.crypto_list.router.CryptoListRouter
import com.example.architectureexample.presentation.ui.crypto_list.viewmodel.CryptoViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

@ActivityScope
class MainViewModel @Inject constructor(
    private val getCryptoUseCase: GetCryptoUseCase,
    private val cryptoListRouter: CryptoListRouter
) : BaseViewModel() {
    private val _cryptoList = MutableLiveData<List<CryptoViewModel>>()
    val cryptoList: LiveData<List<CryptoViewModel>> = _cryptoList

    private val _cryptoInfo = MutableLiveData<CryptoViewModel>()
    val cryptoInfo: LiveData<CryptoViewModel> = _cryptoInfo

    val onItemClickListener by lazy {
        object : OnItemClickListener<CryptoViewModel> {
            override fun onClick(item: CryptoViewModel) {
                onCryptoItemClicked(item)
            }
        }
    }

    init {
        loadCryptoList()
    }

    fun loadCryptoList() {
        disposables.add(
            getCryptoUseCase.getCryptoList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    onCryptoListLoaded(),
                    onCryptoListLoadingError()
                )
        )
    }

    fun loadCryptoInfo(cryptoSymbol: String) {
        disposables.add(
            getCryptoUseCase.getCryptoBy(cryptoSymbol)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    onCryptoInfoLoaded(),
                    onCryptoInfoLoadingError()
                )
        )
    }

    fun onCryptoListClosed() {
        _cryptoList.value = null
    }

    fun onCryptoInfoClosed() {
        _cryptoInfo.value = null
    }

    private fun onCryptoItemClicked(cryptoViewModel: CryptoViewModel) {
        cryptoListRouter.openCryptoInfoScreen(cryptoViewModel.symbol.get()!!)
    }

    private fun onCryptoListLoaded(): (cryptoList: List<CryptoViewModel>) -> Unit =
        {
            Timber.d(TIMBER_MSG_SUCCESS_GET_CRYPTO_LIST)
            _cryptoList.value = it
        }

    private fun onCryptoListLoadingError(): (t: Throwable) -> Unit = {
        Timber.d(it)
        // TODO: handle error on UI
    }

    private fun onCryptoInfoLoaded(): (cryptoInfo: CryptoViewModel) -> Unit =
        {
            Timber.d(TIMBER_MSG_SUCCESS_GET_CRYPTO_LIST)
            _cryptoInfo.value = it
        }

    private fun onCryptoInfoLoadingError(): (t: Throwable) -> Unit = {
        Timber.d(it)
        // TODO: handle error on UI
    }
}