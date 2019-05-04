package com.example.fancyFilterService

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForObject
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class FancyFilterServiceApplicationTests {
    @Autowired
    lateinit var restTemplate: TestRestTemplate

    @Test
    fun `should return UP for health endpoint`() {
        val response = restTemplate.getForObject<String>("/actuator/health")

        assertThat(response).contains("UP")
    }
}
