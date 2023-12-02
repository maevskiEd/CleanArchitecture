package com.example.cleanarchitecturekiparokovalenko.domain.usecase

import com.example.cleanarchitecturekiparokovalenko.domain.models.SaveUserNameParam
import com.example.cleanarchitecturekiparokovalenko.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) {
    fun execute(param: SaveUserNameParam): Boolean {
        val result: Boolean = userRepository.saveName(saveparam = param)
        return result

        /*        if (param.name.isEmpty()) {
                    return false
                } else {
                    return true
                }*/
    }
}