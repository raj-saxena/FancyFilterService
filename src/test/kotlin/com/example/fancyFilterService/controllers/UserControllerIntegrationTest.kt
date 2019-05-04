package com.example.fancyFilterService.controllers

import com.example.fancyFilterService.builders.UserTestBuilder
import com.example.fancyFilterService.dtos.Users
import com.example.fancyFilterService.services.UserService
import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForObject
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
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
}
