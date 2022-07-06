package com.alianhakim.api.service

import com.alianhakim.api.model.*

interface PersonalInfoService {
    fun create(request: PersonalInfoRequest): PersonalInfoResponse

    fun get(id: String): PersonalInfoResponse

    fun update(id: String, request: PersonalInfoUpdateRequest): PersonalInfoResponse

    fun delete(id: String)

    fun getByUserId(userId: String): List<PersonalInfoResponse>
}