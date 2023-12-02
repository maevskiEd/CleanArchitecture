package com.example.cleanarchitecturekiparokovalenko.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cleanarchitecturekiparokovalenko.domain.models.SaveUserNameParam
import com.example.cleanarchitecturekiparokovalenko.domain.models.UserName
import com.example.cleanarchitecturekiparokovalenko.domain.usecase.GetUserNameUseCase
import com.example.cleanarchitecturekiparokovalenko.domain.usecase.SaveUserNameUseCase

//Из ViewModel ничего не должно возвращаться. Мы что-то туда отправляем и подписываемся на изменения
class MainActivityViewModel(
    private val saveUserNameUseCase: SaveUserNameUseCase,
    private val getUserNameUseCase: GetUserNameUseCase
) : ViewModel() {

    private val resultLiveMutable = MutableLiveData<String>()
    val resultLive: LiveData<String> = resultLiveMutable

    init {
        Log.e("TAG", "VM Created")
    }

    override fun onCleared() {
        Log.e("TAG", "VM Cleared")
        super.onCleared()
    }

    fun save(text: String) {
        val params = SaveUserNameParam(name = text)
        val resultData: Boolean = saveUserNameUseCase.execute(param = params)
        resultLiveMutable.value = "Save result = $resultData"
    }

    fun load() {
        val userName: UserName = getUserNameUseCase.execute()
        resultLiveMutable.value = "${userName.firstName} ${userName.lastName}"
    }
}