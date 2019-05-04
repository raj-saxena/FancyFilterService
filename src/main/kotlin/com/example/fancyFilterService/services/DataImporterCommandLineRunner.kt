package com.example.fancyFilterService.services

import org.apache.logging.log4j.LogManager
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Service

@Service
class DataImporterCommandLineRunner(
    val userService: UserService,
    val jsonImporterService: JsonImporterService
) : CommandLineRunner {
    val log = LogManager.getLogger(javaClass)

    override fun run(vararg args: String?) {
        if (userService.getUserCount() == 0) {
            val users = jsonImporterService.loadUsers()
            userService.save(users.users)
            log.info("Loaded ${users.users.size} users.")
        }
    }
}
