package com.example.architectureexample.domain.usecase

import com.example.architectureexample.presentation.ui.crypto_list.viewmodel.CryptoViewModel
import io.reactivex.Single

interface GetCryptoUseCase {
    fun getCryptoList(): Single<List<CryptoViewModel>>
    fun getCryptoBy(symbol: String): Single<CryptoViewModel>
}