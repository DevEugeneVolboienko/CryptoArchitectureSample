package com.example.architectureexample.presentation.ui.crypto_info.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.architectureexample.data.CRYPTO_INFO_ACTIVITY_DATA_SYMBOL
import com.example.architectureexample.databinding.FragmentCryptoInfoBinding
import com.example.architectureexample.presentation.ui.base.BaseFragment
import com.example.architectureexample.presentation.ui.main.MainActivity
import com.example.architectureexample.presentation.ui.main.MainViewModel
import javax.inject.Inject

class CryptoInfoFragment : BaseFragment() {
    @Inject
    lateinit var mainViewModel: MainViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity as MainActivity).mainComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val cryptoSymbol = requireArguments().getString(CRYPTO_INFO_ACTIVITY_DATA_SYMBOL)
        val binding = FragmentCryptoInfoBinding.inflate(inflater, container, false).apply {
            viewModel = mainViewModel
            lifecycleOwner = activity
        }
        openCryptoInfoScreen(cryptoSymbol)
        return binding.root
    }

    override fun onDestroy() {
        mainViewModel.onCryptoInfoClosed()
        super.onDestroy()
    }

    private fun openCryptoInfoScreen(cryptoSymbol: String?) {
        if (arguments != null && cryptoSymbol != null) {
            mainViewModel.loadCryptoInfo(cryptoSymbol)
        }
    }
}