package com.example.fancyFilterService.dtos

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.UUID

data class Users(val users: List<User>)

data class User(
    val id: UUID? = null,
    @JsonProperty("display_name") val displayName: String,
    val age: Int,
    @JsonProperty("job_title") val jobTitle: String,
    @JsonProperty("height_in_cm") val heightInCm: Int,
    val city: City,
    @JsonProperty("main_photo") val mainPhoto: String?,
    @JsonProperty("compatibility_score") val compatibilityScore: Float,
    @JsonProperty("contacts_exchanged") val contactsExchanged: Int,
    val favourite: Boolean,
    val religion: String
)

data class City(
    val id: UUID? = null,
    val name: String,
    @JsonProperty("lat") val latitude: Double,
    @JsonProperty("lon") val longitude: Double
)
