package com.example.fancyFilterService

import com.example.fancyFilterService.dtos.Users
import org.assertj.core.api.AbstractAssert
import org.assertj.core.api.Assertions.assertThat

class UsersAssert(actual: Users) : AbstractAssert<UsersAssert, Users>(actual, UsersAssert::class.java) {
    companion object {
        fun assertThat(actual: Users) = UsersAssert(actual)
    }

    override fun isEqualTo(expected: Any): UsersAssert {
        isInstanceOf(Users::class.java)
        val expectedUsers = expected as Users
        assertThat(actual.users).hasSize(expectedUsers.users.size)
        actual.users.forEachIndexed { i, user ->
            val expectedUser = expectedUsers.users[i]
            assertThat(user).isEqualToIgnoringGivenFields(expectedUser, "id", "city")
            assertThat(user.city).isEqualToIgnoringGivenFields(expectedUser.city, "id")
        }
        return this
    }
}
