package com.example.architectureexample.presentation.ui.crypto_list.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.architectureexample.databinding.FragmentCryptoListBinding
import com.example.architectureexample.presentation.ui.base.BaseFragment
import com.example.architectureexample.presentation.ui.base.listener.OnItemClickListener
import com.example.architectureexample.presentation.ui.crypto_list.adapter.CryptoListAdapter
import com.example.architectureexample.presentation.ui.crypto_list.viewmodel.CryptoViewModel
import com.example.architectureexample.presentation.ui.main.MainActivity
import com.example.architectureexample.presentation.ui.main.MainViewModel
import javax.inject.Inject

class CryptoListFragment : BaseFragment() {
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
        val binding = FragmentCryptoListBinding.inflate(inflater, container, false).apply {
            viewModel = mainViewModel
            lifecycleOwner = activity
        }
        return binding.root
    }

    override fun onDestroy() {
        mainViewModel.onCryptoListClosed()
        super.onDestroy()
    }
}

//sealed class OpenCryptoInfoState
//object OpenCryptoInfoSuccess : OpenCryptoInfoState()
//data class OpenCryptoInfoError(val error: String) : OpenCryptoInfoState()
