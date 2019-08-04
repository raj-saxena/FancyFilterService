package com.example.fancyFilterService.services

import org.apache.logging.log4j.LogManager
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Service

@Service
@Profile("!test")
class DataImporterCommandLineRunner(
    val userService: UserService,
    val jsonImporterService: JsonImporterService,
    @Value("\${app.run-data-importer}") val enabled: Boolean
) : CommandLineRunner {
    val log = LogManager.getLogger(javaClass)

    override fun run(vararg args: String?) {
        if (enabled && userService.getUserCount() == 0) {
            val users = jsonImporterService.loadUsers()
            userService.save(users.users)
            log.info("Loaded ${users.users.size} users.")
        }
    }
}
