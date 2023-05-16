package com.example.architectureexample.core

import android.app.Application
import com.example.architectureexample.presentation.di.component.AppComponent
import com.example.architectureexample.presentation.di.component.DaggerAppComponent
import com.example.architectureexample.presentation.di.module.AppModule
import com.example.architectureexample.presentation.di.module.NetworkModule
import com.example.architectureexample.presentation.di.module.RoomModule

class App : Application() {
    val appComponent: AppComponent = DaggerAppComponent.builder()
        .appModule(AppModule(this))
        .networkModule(NetworkModule())
        .roomModule(RoomModule())
        .build()
}