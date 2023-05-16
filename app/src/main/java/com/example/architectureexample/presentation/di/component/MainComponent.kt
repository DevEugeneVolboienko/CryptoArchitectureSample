package com.example.architectureexample.presentation.di.component

import com.example.architectureexample.presentation.di.module.MainActivityModule
import com.example.architectureexample.presentation.di.scope.ActivityScope
import com.example.architectureexample.presentation.ui.crypto_info.view.CryptoInfoFragment
import com.example.architectureexample.presentation.ui.crypto_list.view.CryptoListFragment
import com.example.architectureexample.presentation.ui.main.MainActivity
import dagger.BindsInstance
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [MainActivityModule::class])
interface MainComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance mainActivity: MainActivity): MainComponent
    }

    fun inject(mainActivity: MainActivity)
    fun inject(cryptoListFragment: CryptoListFragment)
    fun inject(cryptoInfoFragment: CryptoInfoFragment)
}