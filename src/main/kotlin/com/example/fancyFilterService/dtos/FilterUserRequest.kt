package com.example.fancyFilterService.dtos

data class FilterUserRequest(
    val hasPhoto: Boolean? = null,
    val inContact: Boolean? = null,
    val favourite: Boolean? = null,
    val compatibilityScore: Float? = null,
    val age: Int? = null
)
