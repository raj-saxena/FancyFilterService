package com.example.fancyFilterService.repositories

import com.example.fancyFilterService.builders.UserTestBuilder
import com.example.fancyFilterService.dtos.User
import com.example.fancyFilterService.latitude
import com.example.fancyFilterService.longitude
import jooq.fancy.filter.app.Tables.APP_USER
import jooq.fancy.filter.app.Tables.CITY
import org.assertj.core.api.Assertions.assertThat
import org.jooq.DSLContext
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import com.example.fancyFilterService.dtos.City as CityDto

@ExtendWith(SpringExtension::class)
@SpringBootTest
class UserRepositoryIntegrationTest {
    @Autowired
    private lateinit var userRepository: UserRepository

    @Autowired
    protected lateinit var jooq: DSLContext

    @BeforeEach
    fun setUp() {
        jooq.deleteFrom(APP_USER).execute()
        jooq.deleteFrom(CITY).execute()
    }

    @Test
    fun `should save users`() {
        val users = listOf(UserTestBuilder().build())

        userRepository.save(users)

        val savedUsers = userRepository.getUsers()
        assertThat(savedUsers).isEqualTo(users)
    }

    @Test
    fun `should return userCount`() {
        val userCountInitial = userRepository.getUserCount()
        val users = listOf(UserTestBuilder().build())

        userRepository.save(users)
        val userCountAfterSave = userRepository.getUserCount()

        assertThat(userCountAfterSave).isEqualTo(userCountInitial + 1)
    }
}
