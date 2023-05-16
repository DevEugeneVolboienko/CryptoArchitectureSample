package com.example.architectureexample.presentation.di.module

import com.example.architectureexample.presentation.di.scope.ActivityScope
import com.example.architectureexample.presentation.ui.crypto_list.router.CryptoListRouter
import com.example.architectureexample.presentation.ui.crypto_list.router.CryptoListRouterImpl
import com.example.architectureexample.presentation.ui.main.MainActivity
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {
    @ActivityScope
    @Provides
    fun provideRouter(mainActivity: MainActivity): CryptoListRouter =
        CryptoListRouterImpl(mainActivity)
}