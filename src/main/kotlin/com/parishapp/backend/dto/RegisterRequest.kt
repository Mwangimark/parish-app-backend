package com.parishapp.backend.dto

data class RegisterRequest(
    val name: String,
    val email: String,
    val password: String
)
