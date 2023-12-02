package com.example.cleanarchitecturekiparokovalenko.data.repository

import android.content.Context
import com.example.cleanarchitecturekiparokovalenko.domain.models.SaveUserNameParam
import com.example.cleanarchitecturekiparokovalenko.domain.models.UserName
import com.example.cleanarchitecturekiparokovalenko.domain.repository.UserRepository

//В модуле data не должно быть ни какой логики. Только сохранение и получение
private const val SHARED_PREFS_NAME = "shared_prefs_name"
private const val KEY_FIRST_NAME = "firstName"
private const val KEY_LAST_NAME = "lastName"
private const val DEFAULT_NAME = "Default last name"

class UserRepositoryImpl(private val context: Context) : UserRepository {

    private val sharedPreferences =
        context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    override fun saveName(saveparam: SaveUserNameParam): Boolean {
        sharedPreferences.edit().putString(KEY_FIRST_NAME, saveparam.name).apply()

        return true
    }

    override fun getName(): UserName {
        val firstName = sharedPreferences.getString(KEY_FIRST_NAME, "") ?: ""
        val lastName = sharedPreferences.getString(KEY_LAST_NAME, DEFAULT_NAME) ?: DEFAULT_NAME
        return UserName(firstName = firstName, lastName = lastName)
    }
}