package com.example.architectureexample.presentation.mapper

import com.example.architectureexample.data.entity.CryptoEntity
import com.example.architectureexample.presentation.ui.crypto_list.viewmodel.CryptoViewModel
import io.reactivex.SingleTransformer
import timber.log.Timber

fun mapCryptoList(): SingleTransformer<List<CryptoEntity>, List<CryptoViewModel>> =
    SingleTransformer { cryptoEntitiesSingle ->
        cryptoEntitiesSingle.map { cryptoEntities ->
            Timber.d(cryptoEntities.toString())
            cryptoEntities.map {
                CryptoViewModel().apply {
                    id.set(it.id)
                    name.set(it.name)
                    symbol.set(it.symbol)
                }
            }
        }
    }

fun mapCrypto(): SingleTransformer<CryptoEntity, CryptoViewModel> =
    SingleTransformer { cryptoEntitySingle ->
        cryptoEntitySingle.map { cryptoEntity ->
            Timber.d(cryptoEntity.toString())
            CryptoViewModel().apply {
                id.set(cryptoEntity.id)
                name.set(cryptoEntity.name)
                symbol.set(cryptoEntity.symbol)
            }
        }
    }