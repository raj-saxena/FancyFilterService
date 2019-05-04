package com.example.fancyFilterService.services

import com.example.fancyFilterService.dtos.User
import com.example.fancyFilterService.dtos.Users
import com.example.fancyFilterService.repositories.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(val userRepository: UserRepository) {
    fun getUsers(): Users = Users(userRepository.getUsers())
    fun getUserCount(): Int = TODO()
    fun save(users: List<User>): Unit = TODO()
}
