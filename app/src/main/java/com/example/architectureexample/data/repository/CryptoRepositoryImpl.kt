package com.example.architectureexample.data.repository

import com.example.architectureexample.data.db.CryptoDAO
import com.example.architectureexample.data.entity.CryptoEntity
import com.example.architectureexample.data.mapper.toCryptoEntities
import com.example.architectureexample.data.mapper.toCryptoEntity
import com.example.architectureexample.data.network.CryptoApi
import com.example.architectureexample.domain.repository.CryptoRepository
import com.example.architectureexample.domain.response.CryptoResponse
import io.reactivex.Single
import io.reactivex.SingleTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CryptoRepositoryImpl @Inject constructor(
    private val cryptoDAO: CryptoDAO, private val cryptoApi: CryptoApi
) : CryptoRepository {
    override fun getCryptoList(): Single<List<CryptoEntity>> =
        cryptoApi.getCryptoList().compose(saveCryptoListToDatabase())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    override fun getCryptoBy(symbol: String): Single<CryptoEntity> =
        cryptoDAO.selectCryptoBy(symbol).map { cryptoEntityList ->
            cryptoEntityList.first { it.symbol.equals(symbol) }
        }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    private fun saveCryptoListToDatabase(): SingleTransformer<List<CryptoResponse>, List<CryptoEntity>> =
        SingleTransformer { cryptoResponses ->
            Timber.d(cryptoResponses.toString())
            cryptoResponses.map { it.toCryptoEntities() }.doAfterSuccess {
                saveBooks(it)
            }
        }

    private fun saveBooks(cryptoEntities: List<CryptoEntity>) {
        cryptoDAO.insertAll(cryptoEntities)
    }
}