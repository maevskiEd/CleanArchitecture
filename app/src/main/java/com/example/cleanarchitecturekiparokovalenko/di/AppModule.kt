package com.example.cleanarchitecturekiparokovalenko.di

import android.content.Context
import com.example.cleanarchitecturekiparokovalenko.domain.usecase.GetUserNameUseCase
import com.example.cleanarchitecturekiparokovalenko.domain.usecase.SaveUserNameUseCase
import com.example.cleanarchitecturekiparokovalenko.presentation.MainActivityViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AppModule(val context: Context) {

    @Provides
    fun provideContext(): Context {
        return context
    }

    @Provides
    fun provideMainActivityViewModelFactory(
        saveUserNameUseCase: SaveUserNameUseCase,
        getUserNameUseCase: GetUserNameUseCase
    ): MainActivityViewModelFactory {
        return MainActivityViewModelFactory(
            saveUserNameUseCase = saveUserNameUseCase,
            getUserNameUseCase = getUserNameUseCase
        )
    }
}