package com.alianhakim.api.service

import com.alianhakim.api.model.AuthRequest
import com.alianhakim.api.model.AuthResponse

interface UserService {
    fun login(username: String, password: String): AuthResponse
    fun register(request: AuthRequest): AuthResponse
}