package com.example.fancyFilterService.configs

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.PropertyNamingStrategy.SNAKE_CASE
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class JacksonConfig {

    @Bean
    fun objectMapper(): ObjectMapper {
        return ObjectMapper().apply {
            configure(FAIL_ON_UNKNOWN_PROPERTIES, false)
            setDefaultPropertyInclusion(JsonInclude.Include.NON_ABSENT)
            registerModule(Jdk8Module().configureAbsentsAsNulls(true))
            findAndRegisterModules()
            propertyNamingStrategy = SNAKE_CASE
        }
    }
}
