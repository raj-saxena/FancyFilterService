package com.example.fancyFilterService.services

import com.example.fancyFilterService.UsersAssert.Companion.assertThat
import com.example.fancyFilterService.builders.UserTestBuilder
import com.example.fancyFilterService.dtos.City
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
        val expectedUser = UserTestBuilder(
            displayName = "Caroline",
            age = 41,
            jobTitle = "Corporate Lawyer",
            heightInCm = 153,
            city = City(
                name = "Leeds",
                latitude = 53.801277,
                longitude = -1.548567
            ),
            mainPhoto = "http://thecatapi.com/api/images/get?format=src&type=gif",
            compatibilityScore = 0.76F,
            contactsExchanged = 2,
            favourite = true,
            religion = "Atheist"
        ).build()

        val userImporterService = JsonImporterService("/test-users.json", mapper)

        val users = userImporterService.loadUsers()

        assertThat(users).isEqualTo(Users(listOf(expectedUser)))
    }
}
