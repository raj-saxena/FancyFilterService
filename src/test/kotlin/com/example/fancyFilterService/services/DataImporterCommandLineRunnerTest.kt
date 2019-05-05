package com.example.fancyFilterService.services

import com.example.fancyFilterService.builders.UserTestBuilder
import com.example.fancyFilterService.dtos.Users
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.verifyNoMoreInteractions
import com.nhaarman.mockitokotlin2.whenever
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class DataImporterCommandLineRunnerTest {
    private val jsonImporterService = mock<JsonImporterService>()
    private val userService = mock<UserService>()

    private lateinit var dataImporterCommandLineRunner: DataImporterCommandLineRunner

    @BeforeEach
    fun setUp() {
        dataImporterCommandLineRunner = DataImporterCommandLineRunner(userService, jsonImporterService, true)
    }

    @Test
    fun `should insert users`() {
        whenever(userService.getUserCount()).thenReturn(0)
        val importedUsers = Users(listOf(UserTestBuilder().build()))
        whenever(jsonImporterService.loadUsers()).thenReturn(importedUsers)

        dataImporterCommandLineRunner.run()

        verify(userService).getUserCount()
        verify(jsonImporterService).loadUsers()
        verify(userService).save(importedUsers.users)
    }

    @Test
    fun `should skip data insert if users present`() {
        whenever(userService.getUserCount()).thenReturn(1)

        dataImporterCommandLineRunner.run()

        verify(userService).getUserCount()
        verifyNoMoreInteractions(jsonImporterService)
    }
}
