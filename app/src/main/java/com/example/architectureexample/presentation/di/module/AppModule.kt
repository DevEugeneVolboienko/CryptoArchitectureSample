package com.example.architectureexample.presentation.di.module

import com.example.architectureexample.core.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val app: App) {
    @Singleton
    @Provides
    fun provideApplication() = app
}