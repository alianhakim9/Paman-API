package com.alianhakim.api.model

data class ResetPasswordRequest(
    val username: String,
    val newPassword: String
)
