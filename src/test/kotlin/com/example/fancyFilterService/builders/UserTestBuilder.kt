package com.example.fancyFilterService.builders

import com.example.fancyFilterService.dtos.City
import com.example.fancyFilterService.dtos.User
import java.util.UUID

class UserTestBuilder(
    private val id: UUID = UUID.randomUUID(),
    private val displayName: String = "Caroline",
    private val age: Int = 41,
    private val jobTitle: String = "Corporate Lawyer",
    private val heightInCm: Int = 153,
    private val city: City = City(UUID.randomUUID(), "Leeds", 53.801277, -1.548567),
    private val mainPhoto: String = "http://thecatapi.com/api/images/get?format=src&type=gif",
    private val compatibilityScore: Float = 0.76F,
    private val contactsExchanged: Int = 2,
    private val favourite: Boolean = true,
    private val religion: String = "Atheist"
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
