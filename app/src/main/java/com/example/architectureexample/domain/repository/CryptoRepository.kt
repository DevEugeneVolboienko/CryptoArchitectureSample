package com.example.architectureexample.domain.repository

import com.example.architectureexample.data.entity.CryptoEntity
import io.reactivex.Single

interface CryptoRepository {
    fun getCryptoList(): Single<List<CryptoEntity>>
    fun getCryptoBy(symbol: String): Single<CryptoEntity>
}