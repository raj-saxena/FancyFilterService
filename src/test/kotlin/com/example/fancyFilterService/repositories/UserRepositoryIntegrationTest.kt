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
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import kotlin.random.Random

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

    @Nested
    inner class FilterTest {
        @Test
        fun `should return users filtered by photo`() {
            val userWithoutPhoto = UserTestBuilder(seed = 1, mainPhoto = null).build()
            val userWithPhoto = UserTestBuilder(seed = 2, mainPhoto = "somePhoto").build()
            userRepository.save(listOf(userWithPhoto, userWithoutPhoto))

            val actual = userRepository.getUsersFilterBy(FilterUserRequest(hasPhoto = true))

            assertThat(actual).containsOnly(userWithPhoto)
        }

        @Test
        fun `should return users having contacts more than 0`() {
            val userWithNoContacts = UserTestBuilder(seed = 1, contactsExchanged = 0).build()
            val userWithContacts = UserTestBuilder(seed = 2, contactsExchanged = 3).build()
            userRepository.save(listOf(userWithNoContacts, userWithContacts))

            val actual = userRepository.getUsersFilterBy(FilterUserRequest(inContact = true))

            assertThat(actual).containsOnly(userWithContacts)
        }

        @Test
        fun `should return favorite users`() {
            val notAFavoriteUser = UserTestBuilder(seed = 1, favourite = false).build()
            val favoriteUser = UserTestBuilder(seed = 2, favourite = true).build()
            userRepository.save(listOf(notAFavoriteUser, favoriteUser))

            val favoriteUsers = userRepository.getUsersFilterBy(FilterUserRequest(favourite = true))
            assertThat(favoriteUsers).containsOnly(favoriteUser)

            val nonFavoriteUsers = userRepository.getUsersFilterBy(FilterUserRequest(favourite = false))
            assertThat(nonFavoriteUsers).containsOnly(notAFavoriteUser)
        }

        @Test
        fun `should return users having compatibilityScore equal to or greater than`() {
            val threshold = Random.nextInt(1, 99).toFloat()
            val userAboveThreshold = UserTestBuilder(seed = 1, compatibilityScore = threshold.plus(1)).build()
            val userEqualThreshold = UserTestBuilder(seed = 2, compatibilityScore = threshold).build()
            val userBelowThreshold = UserTestBuilder(seed = 3, compatibilityScore = threshold.minus(1)).build()
            userRepository.save(listOf(userAboveThreshold, userEqualThreshold, userBelowThreshold))

            val actual = userRepository.getUsersFilterBy(FilterUserRequest(compatibilityScore = threshold))

            assertThat(actual).containsOnly(userEqualThreshold, userAboveThreshold)
        }

        @Test
        fun `should return users with age less than or equal to`() {
            val maxAge = Random.nextInt(18, 95)
            val userAboveAge = UserTestBuilder(seed = 1, age = maxAge.plus(1)).build()
            val userEqualAge = UserTestBuilder(seed = 2, age = maxAge).build()
            val userBelowAge = UserTestBuilder(seed = 3, age = maxAge.minus(1)).build()
            userRepository.save(listOf(userAboveAge, userEqualAge, userBelowAge))

            val actual = userRepository.getUsersFilterBy(FilterUserRequest(age = maxAge))

            assertThat(actual).containsOnly(userEqualAge, userBelowAge)
        }

        @Test
        fun `should return users with height more than and not equal to`() {
            val height = Random.nextInt(135, 210)
            val userAboveHeight = UserTestBuilder(seed = 1, heightInCm = height.plus(1)).build()
            val userEqualHeight = UserTestBuilder(seed = 2, heightInCm = height).build()
            val userBelowHeight = UserTestBuilder(seed = 3, heightInCm = height.minus(1)).build()
            userRepository.save(listOf(userAboveHeight, userEqualHeight, userBelowHeight))

            val actual = userRepository.getUsersFilterBy(FilterUserRequest(height = height))

            assertThat(actual).containsOnly(userAboveHeight)
        }
    }
}
