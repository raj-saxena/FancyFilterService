package com.example.fancyFilterService.services

import com.example.fancyFilterService.repositories.UserRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Service

@Service
class DataImporterCommandLineRunner(
    val userRepository: UserRepository,
    val jsonImporterService: JsonImporterService
) : CommandLineRunner {
    override fun run(vararg args: String?) {
        if (userRepository.getUserCount() == 0) {
            val users = jsonImporterService.loadUsers()
            userRepository.save(users.users)
        }
    }
}
