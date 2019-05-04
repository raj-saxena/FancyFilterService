package com.example.fancyFilterService.services

import com.example.fancyFilterService.builders.UserTestBuilder
import com.example.fancyFilterService.dtos.Users
import com.fasterxml.jackson.databind.ObjectMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@SpringBootTest
class JsonImporterServiceIntegrationTest {

    @Autowired
    private lateinit var mapper: ObjectMapper

    @Test
    fun `should return empty for non-existent file`() {
        val userImporterService = JsonImporterService("/non-existent-file.json", mapper)

        val users = userImporterService.loadUsers()

        assertThat(users.users).isEmpty()
    }

    @Test
    fun `should read from json file and return list of User`() {
        val expectedUser = UserTestBuilder().build()

        val userImporterService = JsonImporterService("/test-users.json", mapper)

        val users: Users = userImporterService.loadUsers()

        assertThat(users).isEqualTo(Users(listOf(expectedUser)))
    }
}
