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


        val savedUsers = jooq.selectFrom(
            APP_USER.join(CITY).on(APP_USER.CITY_ID.eq(CITY.ID))
        ).map {
            User(
                it.get(APP_USER.DISPLAY_NAME),
                it.get(APP_USER.AGE).toInt(),
                it.get(APP_USER.JOB_TITLE),
                it.get(APP_USER.HEIGHT_IN_CM).toInt(),
                CityDto(
                    it.get(CITY.CITY_NAME), it.get(CITY.COORDINATES).latitude(), it.get(CITY.COORDINATES).longitude()
                ),
                it.get(APP_USER.MAIN_PHOTO),
                it.get(APP_USER.COMPATIBILITY_SCORE).toFloat(),
                it.get(APP_USER.CONTACTS_EXCHANGED).toInt(),
                it.get(APP_USER.FAVORITE),
                it.get(APP_USER.RELIGION)
            )
        }

        assertThat(savedUsers).isEqualTo(users)
    }


}
