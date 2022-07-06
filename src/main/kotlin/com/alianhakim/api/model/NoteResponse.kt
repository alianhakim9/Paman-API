package com.alianhakim.api.model

data class NoteResponse(
    val id: String,
    val noteTitle: String,
    val noteDescription: String,
    val createdAt: String,
    val updatedAt: String
)
