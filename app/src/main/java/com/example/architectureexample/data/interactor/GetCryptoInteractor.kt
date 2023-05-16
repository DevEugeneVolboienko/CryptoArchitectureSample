package com.example.architectureexample.data.interactor

import com.example.architectureexample.domain.repository.CryptoRepository
import com.example.architectureexample.domain.usecase.GetCryptoUseCase
import com.example.architectureexample.presentation.mapper.mapCrypto
import com.example.architectureexample.presentation.mapper.mapCryptoList
import com.example.architectureexample.presentation.ui.crypto_list.viewmodel.CryptoViewModel
import io.reactivex.Single
import javax.inject.Inject

class GetCryptoInteractor @Inject constructor(private val cryptoRepository: CryptoRepository) :
    GetCryptoUseCase {
    override fun getCryptoList(): Single<List<CryptoViewModel>> =
        cryptoRepository.getCryptoList().compose(mapCryptoList())

    override fun getCryptoBy(symbol: String): Single<CryptoViewModel> =
        cryptoRepository.getCryptoBy(symbol).compose(mapCrypto())
}