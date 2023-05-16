package com.example.architectureexample.data.mapper

import com.example.architectureexample.data.entity.CryptoEntity
import com.example.architectureexample.domain.response.CryptoResponse
import timber.log.Timber

fun CryptoResponse.toCryptoEntity(): CryptoEntity = CryptoEntity(id!!, name!!, symbol!!)

fun CryptoEntity.toCryptoResponse() = CryptoResponse(id, name, symbol)

fun List<CryptoResponse>.toCryptoEntities() = apply { Timber.d(toString()) }
    .asSequence()
    .filter { !it.id.isNullOrEmpty() }
    .filter { !it.name.isNullOrEmpty() }
    .filter { !it.symbol.isNullOrEmpty() }
    .map { it.toCryptoEntity() }
    .toList()

fun List<CryptoEntity>.toCryptoResponses() = map { it.toCryptoResponse() }

