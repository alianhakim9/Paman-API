package com.alianhakim.api.service

import com.alianhakim.api.model.*

interface NoteService {
    fun create(request: NoteRequest): NoteResponse

    fun get(id: String): NoteResponse

    fun update(id: String, request: NoteUpdateRequest): NoteResponse

    fun delete(id: String)

    fun getByUserId(userId: String): List<NoteResponse>
}