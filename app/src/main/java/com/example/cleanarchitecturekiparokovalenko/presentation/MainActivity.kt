package com.example.cleanarchitecturekiparokovalenko.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.cleanarchitecturekiparokovalenko.data.repository.UserRepositoryImpl
import com.example.cleanarchitecturekiparokovalenko.data.storage.sharedprefs.SharedPrefUserStorage
import com.example.cleanarchitecturekiparokovalenko.databinding.ActivityMainBinding
import com.example.cleanarchitecturekiparokovalenko.domain.models.SaveUserNameParam
import com.example.cleanarchitecturekiparokovalenko.domain.models.UserName
import com.example.cleanarchitecturekiparokovalenko.domain.usecase.GetUserNameUseCase
import com.example.cleanarchitecturekiparokovalenko.domain.usecase.SaveUserNameUseCase

//Самая главная логика presentation слоя показывать данные и забирать что-то от пользователя
//видео 2
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mainActivityViewModel: MainActivityViewModel

//    private val mainActivityViewModel: MainActivityViewModel by viewModels()

    //by lazy означает что объект будет создан тогда, когда он нам понадобится
    //по умолчанию lazy синхронизирован, нам этого не надо - by lazy(LazyThreadSafetyMode.NONE)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.e("TAG", "Activity Created")

        mainActivityViewModel = ViewModelProvider(
            this,
            MainActivityViewModelFactory(this)
        ).get(MainActivityViewModel::class.java)

        mainActivityViewModel.resultLive.observe(this) { text ->
            binding.dataTextView.text = text
        }

        binding.sendButton.setOnClickListener {
            val text = binding.dataEditText.text.toString()
            mainActivityViewModel.save(text)
        }

        binding.receiveButton.setOnClickListener {
            mainActivityViewModel.load()
        }
    }
}