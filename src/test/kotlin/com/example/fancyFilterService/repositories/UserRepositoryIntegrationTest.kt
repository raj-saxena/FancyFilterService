package com.example.fancyFilterService.repositories

import com.example.fancyFilterService.UsersAssert.Companion.assertThat
import com.example.fancyFilterService.builders.UserTestBuilder
import com.example.fancyFilterService.dtos.FilterUserRequest
import com.example.fancyFilterService.dtos.Users
import jooq.fancy.filter.app.Tables.APP_USER
import jooq.fancy.filter.app.Tables.CITY
import org.assertj.core.api.Assertions.assertThat
import org.jooq.DSLContext
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@SpringBootTest
class UserRepositoryIntegrationTest {
    @Autowired
    private lateinit var userRepository: UserRepository

    @Autowired
    protected lateinit var jooq: DSLContext

    @BeforeEach
    fun setUp() {
        clearDB()
    }

    @AfterEach
    fun tearDown() {
        clearDB()
    }

    private fun clearDB() {
        jooq.deleteFrom(APP_USER).execute()
        jooq.deleteFrom(CITY).execute()
    }

    @Test
    fun `should save users`() {
        val expectedUser = UserTestBuilder().build()
        val users = listOf(expectedUser)

        userRepository.save(users)

        val savedUsers = userRepository.getUsers()

        assertThat(Users(savedUsers)).isEqualTo(Users(savedUsers))
    }

    @Test
    fun `should return userCount`() {
        val userCountInitial = userRepository.getUserCount()
        val users = listOf(UserTestBuilder().build())

        userRepository.save(users)
        val userCountAfterSave = userRepository.getUserCount()

        assertThat(userCountAfterSave).isEqualTo(userCountInitial + 1)
    }

    @Test
    fun `should return users filtered by photo`() {
        val userWithPhoto = UserTestBuilder(seed = 1, mainPhoto = "somePhoto").build()
        val userWithoutPhoto = UserTestBuilder(seed = 2, mainPhoto = null).build()
        userRepository.save(listOf(userWithPhoto, userWithoutPhoto))

        val usersWithPhoto = userRepository.getUsersFilterBy(FilterUserRequest(hasPhoto = true))

        assertThat(Users(usersWithPhoto)).isEqualTo(Users(usersWithPhoto))
    }

    @Test
    fun `should return users having contacts more than 0`() {
        val userWithNoContacts = UserTestBuilder(seed = 1, contactsExchanged = 0).build()
        val userWithContacts = UserTestBuilder(seed = 2, contactsExchanged = 3).build()
        userRepository.save(listOf(userWithNoContacts, userWithContacts))

        val usersWithPhoto = userRepository.getUsersFilterBy(FilterUserRequest(inContact = true))

        assertThat(Users(usersWithPhoto)).isEqualTo(Users(usersWithPhoto))
    }
}
