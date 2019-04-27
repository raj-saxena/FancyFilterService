package com.example.fancyFilterService.builders

import com.example.fancyFilterService.dtos.City
import com.example.fancyFilterService.dtos.User

class UserBuilder(
    private val displayName: String = "Caroline",
    private val age: Int = 41,
    private val jobTitle: String = "Corporate Lawyer",
    private val heightInCm: Int = 153,
    private val city: City = City("Leeds", 53.801277F, -1.548567F),
    private val mainPhoto: String = "http://thecatapi.com/api/images/get?format=src&type=gif",
    private val compatibilityScore: Float = 0.76F,
    private val contactsExchanged: Int = 2,
    private val favourite: Boolean = true,
    private val religion: String = "Atheist"
) {
    fun build(): User = User(
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
