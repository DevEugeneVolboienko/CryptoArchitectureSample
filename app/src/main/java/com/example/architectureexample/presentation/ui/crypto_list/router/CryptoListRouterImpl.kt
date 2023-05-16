package com.example.architectureexample.presentation.ui.crypto_list.router

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.architectureexample.R
import com.example.architectureexample.data.CRYPTO_INFO_ACTIVITY_DATA_SYMBOL
import com.example.architectureexample.presentation.ui.crypto_info.view.CryptoInfoFragment
import com.example.architectureexample.presentation.ui.crypto_list.view.CryptoListFragment

class CryptoListRouterImpl(private val context: Context) : CryptoListRouter {
    override fun openCryptoInfoScreen(cryptoSymbol: String) {
        (context as AppCompatActivity).supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, CryptoInfoFragment().apply {
                arguments =
                    Bundle().apply { putString(CRYPTO_INFO_ACTIVITY_DATA_SYMBOL, cryptoSymbol) }
            })
            .addToBackStack(CryptoListFragment::class.java.simpleName)
            .commit()
    }
}