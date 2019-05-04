package com.example.fancyFilterService.services

import com.example.fancyFilterService.builders.UserTestBuilder
import com.example.fancyFilterService.dtos.Users
import com.example.fancyFilterService.repositories.UserRepository
import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

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
}
