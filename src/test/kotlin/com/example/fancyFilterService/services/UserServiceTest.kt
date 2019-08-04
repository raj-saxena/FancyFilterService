package com.example.fancyFilterService.services

import com.example.fancyFilterService.builders.UserTestBuilder
import com.example.fancyFilterService.dtos.FilterUserRequest
import com.example.fancyFilterService.dtos.Users
import com.example.fancyFilterService.repositories.UserRepository
import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.util.Random

class UserServiceTest {
    private lateinit var userService: UserService
    private val userRepository = mock<UserRepository>()

    @BeforeEach
    fun setUp() {
        userService = UserService(userRepository)
    }

    @Test
    fun `should return all users`() {
        val expected = listOf(UserTestBuilder().build())
        given(userRepository.getUsers()).willReturn(expected)

        val actualUsers = userService.getUsers()

        verify(userRepository).getUsers()
        assertThat(actualUsers).isEqualTo(Users(expected))
    }

    @Test
    fun `should return userCount`() {
        val expectedUserCount = Random().nextInt()
        given(userRepository.getUserCount()).willReturn(expectedUserCount)

        val actualUserCount = userService.getUserCount()

        verify(userRepository).getUserCount()
        assertThat(actualUserCount).isEqualTo(expectedUserCount)
    }

    @Test
    fun `should save users in repository`() {
        val users = listOf(UserTestBuilder().build())

        userService.save(users)

        verify(userRepository).save(users)
    }

    @Test
    fun `should get users filter by request`() {
        val filterUserRequest = FilterUserRequest(hasPhoto = false, favourite = null)
        val expected = listOf(UserTestBuilder().build())
        given(userRepository.getUsersFilterBy(filterUserRequest)).willReturn(expected)

        val actual = userService.getUsersFilterBy(filterUserRequest)

        verify(userRepository).getUsersFilterBy(filterUserRequest)
        assertThat(actual).isEqualTo(Users(expected))
    }
}
