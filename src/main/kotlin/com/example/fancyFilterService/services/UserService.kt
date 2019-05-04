package com.example.fancyFilterService.services

import com.example.fancyFilterService.dtos.Users
import com.example.fancyFilterService.repositories.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(val userRepository: UserRepository) {
    fun getUsers(): Users = Users(userRepository.getUsers())
}
