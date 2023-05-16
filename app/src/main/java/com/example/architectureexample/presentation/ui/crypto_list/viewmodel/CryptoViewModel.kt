package com.example.architectureexample.presentation.ui.crypto_list.viewmodel

import androidx.databinding.ObservableField
import com.example.architectureexample.presentation.ui.base.BaseViewModel

class CryptoViewModel : BaseViewModel() {
    val id = ObservableField<String>()
    val name = ObservableField<String>()
    val symbol = ObservableField<String>()
}