package com.example.fancyFilterService.controllers

import com.example.fancyFilterService.dtos.FilterUserRequest
import com.example.fancyFilterService.services.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(val userService: UserService) {

    @GetMapping("/api/users")
    fun getUsers() = userService.getUsers()

    @PostMapping("/api/users/filter")
    fun getUsersFilteredBy(@RequestBody filterUserRequest: FilterUserRequest) =
        userService.getUsersFilterBy(filterUserRequest)
}
