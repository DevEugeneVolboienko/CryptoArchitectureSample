package com.example.architectureexample.data.network

import com.example.architectureexample.domain.response.CryptoResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface CryptoApi {
    @GET("crypto.json")
    fun getCryptoList(@Query("limit") limit: Int = 0): Single<List<CryptoResponse>>
}