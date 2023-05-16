package com.example.architectureexample.presentation.di.module

import com.example.architectureexample.presentation.di.component.MainComponent
import dagger.Module

@Module(subcomponents = [MainComponent::class])
class AppSubcomponents