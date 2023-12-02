package com.example.cleanarchitecturekiparokovalenko.di

import android.content.Context
import com.example.cleanarchitecturekiparokovalenko.data.repository.UserRepositoryImpl
import com.example.cleanarchitecturekiparokovalenko.data.storage.UserStorage
import com.example.cleanarchitecturekiparokovalenko.data.storage.sharedprefs.SharedPrefUserStorage
import com.example.cleanarchitecturekiparokovalenko.domain.repository.UserRepository
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun provideUserStorage(context: Context): UserStorage {
        return SharedPrefUserStorage(context = context)
    }

    @Provides
    fun provideUserRepository(userStorage: UserStorage): UserRepository {
        return UserRepositoryImpl(userStorage = userStorage)
    }
}