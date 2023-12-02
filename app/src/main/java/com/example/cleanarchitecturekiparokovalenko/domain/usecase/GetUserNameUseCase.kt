package com.example.cleanarchitecturekiparokovalenko.domain.usecase

import com.example.cleanarchitecturekiparokovalenko.domain.models.UserName

class GetUserNameUseCase {
    fun execute(): UserName {
        return UserName(firstName = "First Name", lastName = "Last Name")
    }
}