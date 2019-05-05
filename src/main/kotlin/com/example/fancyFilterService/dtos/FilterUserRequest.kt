package com.example.fancyFilterService.dtos

import com.fasterxml.jackson.annotation.JsonProperty

data class FilterUserRequest(
    @JsonProperty("has_photo")
    val hasPhoto: Boolean? = null,

    @JsonProperty("in_contact")
    val inContact: Boolean? = null
)
