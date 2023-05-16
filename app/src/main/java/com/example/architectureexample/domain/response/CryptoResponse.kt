package com.example.architectureexample.domain.response

import com.google.gson.annotations.SerializedName

data class CryptoResponse(
    @SerializedName("id") var id: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("symbol") var symbol: String? = null
)