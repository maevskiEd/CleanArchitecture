package com.example.cleanarchitecturekiparokovalenko.presentation

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cleanarchitecturekiparokovalenko.data.repository.UserRepositoryImpl
import com.example.cleanarchitecturekiparokovalenko.databinding.ActivityMainBinding
import com.example.cleanarchitecturekiparokovalenko.domain.models.SaveUserNameParam
import com.example.cleanarchitecturekiparokovalenko.domain.models.UserName
import com.example.cleanarchitecturekiparokovalenko.domain.usecase.GetUserNameUseCase
import com.example.cleanarchitecturekiparokovalenko.domain.usecase.SaveUserNameUseCase

//Самая главная логика presentation слоя показывать данные и забирать что-то от пользователя
//видео 2
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    //by lazy означает что объект будет создан тогда, когда он нам понадобится
    //по умолчанию lazy синхронизирован, нам этого не надо - by lazy(LazyThreadSafetyMode.NONE)
    private val userRepository by lazy(LazyThreadSafetyMode.NONE) { UserRepositoryImpl(context = applicationContext) }
    private val getUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) { GetUserNameUseCase(userRepository = userRepository) }
    private val saveUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) { SaveUserNameUseCase(userRepository = userRepository) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.sendButton.setOnClickListener {
            val text = binding.dataEditText.text.toString()
            val params = SaveUserNameParam(name = text)
            val result: Boolean = saveUserNameUseCase.execute(param = params)
            binding.dataTextView.text = "Save result =$result"
        }

        binding.receiveButton.setOnClickListener {
            val userName: UserName = getUserNameUseCase.execute()
            binding.dataTextView.text = "${userName.firstName} ${userName.lastName}"
        }
    }
}