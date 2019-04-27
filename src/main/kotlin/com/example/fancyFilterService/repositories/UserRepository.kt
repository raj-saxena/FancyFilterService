package com.example.fancyFilterService.repositories

import com.example.fancyFilterService.dtos.Users
import org.springframework.stereotype.Repository

@Repository
class UserRepository {

    fun getUserCount() = 0
    fun save(users: Users) {}
}
