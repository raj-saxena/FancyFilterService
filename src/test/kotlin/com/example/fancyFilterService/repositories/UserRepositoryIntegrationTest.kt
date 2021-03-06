package com.example.fancyFilterService.repositories

import com.example.fancyFilterService.UsersAssert.Companion.assertThat
import com.example.fancyFilterService.builders.UserTestBuilder
import com.example.fancyFilterService.dtos.Age
import com.example.fancyFilterService.dtos.City
import com.example.fancyFilterService.dtos.CompatibilityScore
import com.example.fancyFilterService.dtos.DistanceFilter
import com.example.fancyFilterService.dtos.FilterUserRequest
import com.example.fancyFilterService.dtos.Height
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
        fun `should return users having compatibilityScore between`() {
            val min = 0.50f
            val max = 0.80f
            val userUnderRange = UserTestBuilder(seed = 1, compatibilityScore = min.minus(0.1f)).build()
            val userInRange = UserTestBuilder(seed = 2, compatibilityScore = (min + max) / 2).build()
            val userAboveRange = UserTestBuilder(seed = 3, compatibilityScore = max.plus(0.1f)).build()
            userRepository.save(listOf(userUnderRange, userInRange, userAboveRange))

            val actual =
                userRepository.getUsersFilterBy(FilterUserRequest(compatibilityScore = CompatibilityScore(min, max)))

            assertThat(actual).containsOnly(userInRange)
        }

        @Test
        fun `should return users with age less than or equal to`() {
            val min = Random.nextInt(18, 50)
            val max = Random.nextInt(50, 95)
            val userAboveRange = UserTestBuilder(seed = 1, age = max.plus(1)).build()
            val userInRange = UserTestBuilder(seed = 2, age = 50).build()
            val userBelowRange = UserTestBuilder(seed = 3, age = min.minus(1)).build()
            userRepository.save(listOf(userAboveRange, userInRange, userBelowRange))

            val actual = userRepository.getUsersFilterBy(FilterUserRequest(age = Age(min, max)))

            assertThat(actual).containsOnly(userInRange)
        }

        @Test
        fun `should return users with height more than and not equal to`() {
            val min = Random.nextInt(135, 180)
            val max = Random.nextInt(180, 210)
            val userAboveHeight = UserTestBuilder(seed = 1, heightInCm = max.plus(1)).build()
            val userInRange = UserTestBuilder(seed = 2, heightInCm = 180).build()
            val userBelowHeight = UserTestBuilder(seed = 3, heightInCm = min.minus(1)).build()
            userRepository.save(listOf(userAboveHeight, userInRange, userBelowHeight))

            val actual = userRepository.getUsersFilterBy(FilterUserRequest(height = Height(min, max)))

            assertThat(actual).containsOnly(userInRange)
        }

        @Test
        fun `should return users with distance upto input`() {
            // Calculated distance using https://gps-coordinates.org/distance-between-coordinates.php
            val distance = 200
            // current user
            val userCaroline = UserTestBuilder(
                displayName = "Caroline",
                seed = 1,
                city = City(name = "Leeds", latitude = 53.801277, longitude = -1.548567)
            ).build()
            // Sharon's distance from Caroline - 155.15 KM
            val userSharon = UserTestBuilder(
                displayName = "Sharon",
                seed = 2,
                city = City(name = "Solihull", latitude = 52.412811, longitude = -1.778197)
            ).build()
            // Natalia's distance from Caroline - 280.40
            val userNatalia = UserTestBuilder(
                displayName = "Natalia",
                seed = 3,
                city = City(name = "Cardiff", latitude = 51.481583, longitude = -3.179090)
            ).build()
            userRepository.save(listOf(userCaroline, userSharon, userNatalia))

            val actual = userRepository.getUsersFilterBy(
                FilterUserRequest(
                    distanceFilter = DistanceFilter(
                        userId = userCaroline.id!!,
                        origin = userCaroline.city,
                        maxDistanceInKm = distance
                    )
                )
            )

            assertThat(Users(actual)).isEqualTo(Users(listOf(userSharon)))
        }
    }
}
