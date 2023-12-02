package com.example.cleanarchitecturekiparokovalenko.domain.repository

import com.example.cleanarchitecturekiparokovalenko.domain.models.SaveUserNameParam
import com.example.cleanarchitecturekiparokovalenko.domain.models.UserName

interface UserRepository {

    fun saveName(saveparam: SaveUserNameParam): Boolean

    fun getName(): UserName
}