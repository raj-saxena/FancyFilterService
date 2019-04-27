package com.example.fancyFilterService.services

import com.example.fancyFilterService.dtos.Users
import com.fasterxml.jackson.core.JsonFactory
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service


@Service
class UserImporterService(
    @Value("\${user.filename}") private val filepath: String,
    private val mapper: ObjectMapper
) {

    fun loadUsers(): Users {
        val stream = javaClass.getResourceAsStream(filepath)

        return stream?.let {
            mapper.readValue<Users>(JsonFactory().createParser(it))
        } ?: Users(emptyList())
    }
}
