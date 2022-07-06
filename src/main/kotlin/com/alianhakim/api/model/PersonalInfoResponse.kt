package com.alianhakim.api.model

data class PersonalInfoResponse(
    val id: String,
    val piAddress: String,
    val piEmail: String,
    val piPhoneNumber: String,
    val piWebsite: String,
    val createdAt: String,
    val updatedAt: String
)
