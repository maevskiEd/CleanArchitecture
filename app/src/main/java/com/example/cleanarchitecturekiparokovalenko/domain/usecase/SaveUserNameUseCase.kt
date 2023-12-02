package com.example.cleanarchitecturekiparokovalenko.domain.usecase

import com.example.cleanarchitecturekiparokovalenko.domain.models.SaveUserNameParam

class SaveUserNameUseCase {
    fun execute(param: SaveUserNameParam): Boolean {
        return param.name.isNotEmpty()

        /*        if (param.name.isEmpty()) {
                    return false
                } else {
                    return true
                }*/
    }
}