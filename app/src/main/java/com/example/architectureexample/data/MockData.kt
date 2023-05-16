package com.example.architectureexample.data

import com.example.architectureexample.presentation.ui.crypto_list.viewmodel.CryptoViewModel

const val OBJECTS_COUNT = 20

fun mockCryptoViewModelList(): List<CryptoViewModel> = arrayListOf<CryptoViewModel>().apply {
    for (i in 0..OBJECTS_COUNT) {
        this.add(CryptoViewModel().apply {
            id.set("$i")
            name.set("Name $i")
            symbol.set("Symbol $$i")
        })
    }
}