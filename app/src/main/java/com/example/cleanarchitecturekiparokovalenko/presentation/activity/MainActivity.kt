package com.example.cleanarchitecturekiparokovalenko.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.cleanarchitecturekiparokovalenko.app.App
import com.example.cleanarchitecturekiparokovalenko.databinding.ActivityMainBinding
import com.example.cleanarchitecturekiparokovalenko.presentation.viewmodel.MainActivityViewModel
import com.example.cleanarchitecturekiparokovalenko.presentation.viewmodelfactory.MainActivityViewModelFactory
import javax.inject.Inject

//Самая главная логика presentation слоя показывать данные и забирать что-то от пользователя
//видео 2
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
//    private lateinit var mainActivityViewModel: MainActivityViewModel

    @Inject
    lateinit var vmFactory: MainActivityViewModelFactory

    private val mainActivityViewModel: MainActivityViewModel by viewModels{vmFactory}

    //by lazy означает что объект будет создан тогда, когда он нам понадобится
    //по умолчанию lazy синхронизирован, нам этого не надо - by lazy(LazyThreadSafetyMode.NONE)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        (applicationContext as App).appComponent.inject(this)
        Log.e("TAG", "Activity Created")

//        mainActivityViewModel =
//            ViewModelProvider(this, vmFactory).get(MainActivityViewModel::class.java)

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