package com.example.architectureexample.presentation.ui.main

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.architectureexample.R
import com.example.architectureexample.core.App
import com.example.architectureexample.databinding.ActivityMainBinding
import com.example.architectureexample.presentation.di.component.MainComponent
import com.example.architectureexample.presentation.ui.base.BaseActivity
import com.example.architectureexample.presentation.ui.crypto_info.view.CryptoInfoFragment
import com.example.architectureexample.presentation.ui.crypto_list.view.CryptoListFragment
import javax.inject.Inject

class MainActivity : BaseActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var mainComponent: MainComponent

    @Inject
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        mainComponent = (application as App).appComponent.mainComponent().create(this)
        mainComponent.inject(this)
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        openCryptoListScreen()
    }

    private fun openCryptoListScreen() {
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, CryptoListFragment())
            .commit()
    }
}