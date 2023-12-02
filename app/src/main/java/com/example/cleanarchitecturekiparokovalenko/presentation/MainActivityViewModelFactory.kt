package com.example.cleanarchitecturekiparokovalenko.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cleanarchitecturekiparokovalenko.domain.usecase.GetUserNameUseCase
import com.example.cleanarchitecturekiparokovalenko.domain.usecase.SaveUserNameUseCase

class MainActivityViewModelFactory(
    val saveUserNameUseCase: SaveUserNameUseCase,
    val getUserNameUseCase: GetUserNameUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainActivityViewModel(
            saveUserNameUseCase = saveUserNameUseCase,
            getUserNameUseCase = getUserNameUseCase
        ) as T
    }

}