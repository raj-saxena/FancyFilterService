package com.example.fancyFilterService.builders

import com.example.fancyFilterService.dtos.City
import com.example.fancyFilterService.dtos.User
import java.util.UUID

class UserTestBuilder(
    private val seed: Int = 0,
    private val id: UUID = UUID.randomUUID(),
    private val displayName: String = "displayName.$seed",
    private val age: Int = seed + 10,
    private val jobTitle: String = "jobTitle.$seed",
    private val heightInCm: Int = seed + 20,
    private val city: City = City(UUID.randomUUID(), "cityname.$seed", seed + .111, -seed + .111),
    private val mainPhoto: String? = "mainPhoto.$seed",
    private val compatibilityScore: Float = seed / 1 + 0.76F,
    private val contactsExchanged: Int = seed + 3,
    private val favourite: Boolean = seed / 2 == 0,
    private val religion: String = "religion.$seed"
) {
    fun build(): User = User(
        id,
        displayName,
        age,
        jobTitle,
        heightInCm,
        city,
        mainPhoto,
        compatibilityScore,
        contactsExchanged,
        favourite,
        religion
    )
}
