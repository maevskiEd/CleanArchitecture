package com.example.cleanarchitecturekiparokovalenko.domain.usecase

import com.example.cleanarchitecturekiparokovalenko.domain.models.UserName
import com.example.cleanarchitecturekiparokovalenko.domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository: UserRepository) {
    fun execute(): UserName {
        return userRepository.getName()
    }
}