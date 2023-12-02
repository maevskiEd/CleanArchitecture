package com.example.cleanarchitecturekiparokovalenko.data.repository

import com.example.cleanarchitecturekiparokovalenko.data.NetworkApi
import com.example.cleanarchitecturekiparokovalenko.data.storage.UserStorage
import com.example.cleanarchitecturekiparokovalenko.data.storage.models.User
import com.example.cleanarchitecturekiparokovalenko.domain.models.SaveUserNameParam
import com.example.cleanarchitecturekiparokovalenko.domain.models.UserName
import com.example.cleanarchitecturekiparokovalenko.domain.repository.UserRepository

//В модуле data не должно быть ни какой логики. Только сохранение и получение
//В этом классе будут сходиться вся работа с данными - локальными и удаленными
//репозитории и стораджи должны быть без if
//Если хочется добавить if, то создаем новый UseCase
//мапперы - хороший вариант, но extension - еще лучший вариант
class UserRepositoryImpl(private val userStorage: UserStorage, private val networkApi: NetworkApi) :
    UserRepository {

    override fun saveName(saveParam: SaveUserNameParam): Boolean {
        val user = mapToStorage(saveParam)
        val result = userStorage.save(user)
        return result
    }

    override fun getName(): UserName {
        val user = userStorage.get()
        return mapToDomain(user)
    }

    private fun mapToDomain(user: User): UserName {
        return UserName(firstName = user.firstName, lastName = user.lastName)
    }

    private fun mapToStorage(saveParam: SaveUserNameParam): User {
        return User(firstName = saveParam.name, lastName = "")
    }
}