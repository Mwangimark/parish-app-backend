package com.parishapp.backend.service

import com.parishapp.backend.dto.RegisterRequest
import com.parishapp.backend.model.User
import com.parishapp.backend.repository.UserRepository
import org.springframework.security.crypto.bcrypt.BCrypt
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class UserService(private val userRepository: UserRepository) {

    fun register(request: RegisterRequest): User {
        val user = User(
            name = request.name,
            email = request.email,
            passwordHash = hashPassword(request.password),
            role = "USER",
            createdAt = LocalDateTime.now(),
            updatedAt = LocalDateTime.now()
        )
        return userRepository.save(user)
    }

    private fun hashPassword(password: String): String {
        return BCrypt.hashpw(password, BCrypt.gensalt())
    }

    fun getUserById(id: Long): User? {
        return userRepository.findById(id).orElse(null)
    }

    fun listUsers(): List<User> {
        return userRepository.findAll()
    }
}