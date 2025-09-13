package com.parishapp.backend.controller

import com.parishapp.backend.dto.RegisterRequest
import com.parishapp.backend.dto.UserResponse
import com.parishapp.backend.model.User
import com.parishapp.backend.service.UserService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UserController(private val userService: UserService) {

    @PostMapping("/register")
    fun register(@RequestBody request: RegisterRequest): UserResponse {
        val user = userService.register(request)
        return UserResponse.fromEntity(user)
    }

    @GetMapping("/{id}")
    fun getUser(@PathVariable id: Long): User? {
        return userService.getUserById(id)
    }

    @GetMapping
    fun listUsers(): List<User> {
        return userService.listUsers()
    }
}
