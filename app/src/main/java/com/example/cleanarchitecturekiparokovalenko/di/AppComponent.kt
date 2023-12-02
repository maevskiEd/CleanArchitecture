package com.example.cleanarchitecturekiparokovalenko.di

import com.example.cleanarchitecturekiparokovalenko.presentation.MainActivity
import dagger.Component

@Component(modules = [AppModule::class, DataModule::class, DomainModule::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity)
}