package com.example.architectureexample.presentation.di.component

import com.example.architectureexample.presentation.di.module.AppModule
import com.example.architectureexample.presentation.di.module.AppSubcomponents
import com.example.architectureexample.presentation.di.module.NetworkModule
import com.example.architectureexample.presentation.di.module.RoomModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, NetworkModule::class, RoomModule::class, AppSubcomponents::class])
interface AppComponent {
    fun mainComponent(): MainComponent.Factory
}