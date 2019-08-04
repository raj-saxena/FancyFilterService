package com.example.fancyFilterService.controllers

import com.example.fancyFilterService.builders.UserTestBuilder
import com.example.fancyFilterService.dtos.FilterUserRequest
import com.example.fancyFilterService.dtos.Users
import com.example.fancyFilterService.services.UserService
import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForObject
import org.springframework.boot.test.web.client.postForObject
import org.springframework.http.HttpEntity
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class UserControllerIntegrationTest {
    @Autowired
    lateinit var restTemplate: TestRestTemplate

    @MockBean
    lateinit var userService: UserService

    @Test
    fun `should get all users`() {
        val expected = Users(listOf(UserTestBuilder().build()))
        given(userService.getUsers()).willReturn(expected)

        val actual = restTemplate.getForObject<Users>("/api/users")

        verify(userService).getUsers()
        assertThat(actual).isEqualTo(expected)
    }

    @Nested
    inner class FilterTest {
        private val userFilterUrl = "/api/users/filter"

        @Test
        fun `should filter by hasPhoto`() {
            val expected = Users(listOf(UserTestBuilder(mainPhoto = null).build()))
            val filterUserRequest = FilterUserRequest(false, favourite = null)
            given(userService.getUsersFilterBy(filterUserRequest)).willReturn(expected)

            val actual = restTemplate.postForObject<Users>(userFilterUrl, HttpEntity(filterUserRequest))

            verify(userService).getUsersFilterBy(filterUserRequest)
            assertThat(actual).isEqualTo(expected)
        }

        @Test
        fun `should filter by inContact`() {
            val expected = Users(listOf(UserTestBuilder(contactsExchanged = 3).build()))
            val filterUserRequest = FilterUserRequest(inContact = true, favourite = null)
            given(userService.getUsersFilterBy(filterUserRequest)).willReturn(expected)

            val actual = restTemplate.postForObject<Users>(userFilterUrl, HttpEntity(filterUserRequest))

            verify(userService).getUsersFilterBy(filterUserRequest)
            assertThat(actual).isEqualTo(expected)
        }

        @Test
        fun `should filter by favorite`() {
            val expected = Users(listOf(UserTestBuilder(favourite = true).build()))
            val filterUserRequest = FilterUserRequest(favourite = true)
            given(userService.getUsersFilterBy(filterUserRequest)).willReturn(expected)

            val actual = restTemplate.postForObject<Users>(userFilterUrl, HttpEntity(filterUserRequest))

            verify(userService).getUsersFilterBy(filterUserRequest)
            assertThat(actual).isEqualTo(expected)
        }
    }
}
