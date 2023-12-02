package com.example.cleanarchitecturekiparokovalenko.app

import android.app.Application
import com.example.cleanarchitecturekiparokovalenko.di.AppComponent
import com.example.cleanarchitecturekiparokovalenko.di.AppModule
import com.example.cleanarchitecturekiparokovalenko.di.DaggerAppComponent

class App : Application() {

    lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder().appModule(AppModule(context = this)).build()
    }
}