package com.example.fancyFilterService.dtos

import com.fasterxml.jackson.annotation.JsonProperty

data class FilterUserRequest(
    @JsonProperty("has_photo")
    val hasPhoto: Boolean? = null
)
