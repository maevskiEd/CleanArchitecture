package com.example.cleanarchitecturekiparokovalenko.data.storage

import com.example.cleanarchitecturekiparokovalenko.data.storage.models.User

//репозитории и стораджи должны быть без if
//Если хочется добавить if, то создаем новый UseCase
interface UserStorage {

    fun save(user: User): Boolean

    fun get(): User
}