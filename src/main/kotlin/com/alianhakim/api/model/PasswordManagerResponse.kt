package com.alianhakim.api.model

data class PasswordManagerResponse(
    val id: String,
    val pmUsername: String,
    val pmPassword: String,
    val pmWebsite: String,
    val createdAt: String,
    val updatedAt: String
)
