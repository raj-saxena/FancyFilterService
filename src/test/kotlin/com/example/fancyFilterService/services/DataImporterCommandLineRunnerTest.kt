package com.example.fancyFilterService.services

import com.example.fancyFilterService.builders.UserBuilder
import com.example.fancyFilterService.dtos.Users
import com.example.fancyFilterService.repositories.UserRepository
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.verifyNoMoreInteractions
import com.nhaarman.mockitokotlin2.whenever
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class DataImporterCommandLineRunnerTest {
    private val jsonImporterService = mock<JsonImporterService>()
    private val userRepository = mock<UserRepository>()

    private lateinit var dataImporterCommandLineRunner: DataImporterCommandLineRunner

    @BeforeEach
    fun setUp() {
        dataImporterCommandLineRunner = DataImporterCommandLineRunner(userRepository, jsonImporterService)
    }

    @Test
    fun `should insert users`() {
        whenever(userRepository.getUserCount()).thenReturn(0)
        val importedUsers = Users(listOf(UserBuilder().build()))
        whenever(jsonImporterService.loadUsers()).thenReturn(importedUsers)

        dataImporterCommandLineRunner.run()

        verify(userRepository).getUserCount()
        verify(jsonImporterService).loadUsers()
        verify(userRepository).save(importedUsers)
    }

    @Test
    fun `should skip data insert if users present`() {
        whenever(userRepository.getUserCount()).thenReturn(1)

        dataImporterCommandLineRunner.run()

        verify(userRepository).getUserCount()
        verifyNoMoreInteractions(jsonImporterService)
    }

}
