package com.example.fancyFilterService.dtos

import java.util.UUID

data class DistanceFilter(val userId: UUID, val origin: City, val maxDistanceInKm: Int)
data class CompatibilityScore(val min: Float, val max: Float)
data class Age(val min: Int, val max: Int)
data class Height(val min: Int, val max: Int)
data class FilterUserRequest(
    val hasPhoto: Boolean? = null,
    val inContact: Boolean? = null,
    val favourite: Boolean? = null,
    val compatibilityScore: CompatibilityScore? = null,
    val age: Age? = null,
    val height: Height? = null,
    val distanceFilter: DistanceFilter? = null
)
