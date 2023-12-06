package com.example.cleanarchitecturekiparokovalenko.presentation.viewmodelfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cleanarchitecturekiparokovalenko.domain.usecase.GetUserNameUseCase
import com.example.cleanarchitecturekiparokovalenko.domain.usecase.SaveUserNameUseCase
import com.example.cleanarchitecturekiparokovalenko.presentation.viewmodel.MainActivityViewModel

class MainActivityViewModelFactory(
    val saveUserNameUseCase: SaveUserNameUseCase,
    val getUserNameUseCase: GetUserNameUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainActivityViewModel::class.java)) {
            return MainActivityViewModel(
                saveUserNameUseCase = saveUserNameUseCase,
                getUserNameUseCase = getUserNameUseCase
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}