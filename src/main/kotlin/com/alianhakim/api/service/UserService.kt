package com.alianhakim.api.service

import com.alianhakim.api.model.AuthRequest

interface UserService {
    fun login(username: String, password: String): String
    fun register(request: AuthRequest): String
    fun forgotPassword(username: String, newPassword: String)
}