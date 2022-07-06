package com.alianhakim.api.service

import com.alianhakim.api.model.PasswordManagerRequest
import com.alianhakim.api.model.PasswordManagerResponse
import com.alianhakim.api.model.PasswordManagerUpdateRequest

interface PasswordManagerService {
    fun create(request: PasswordManagerRequest): PasswordManagerResponse

    fun get(id: String): PasswordManagerResponse

    fun update(id: String, request: PasswordManagerUpdateRequest): PasswordManagerResponse

    fun delete(id: String)

    fun getByUserId(userId: String): List<PasswordManagerResponse>
}