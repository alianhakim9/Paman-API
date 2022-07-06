package com.alianhakim.api.model

import javax.validation.constraints.NotBlank

data class NoteUpdateRequest(
    @field:NotBlank
    val noteTitle: String,

    @field:NotBlank
    val noteDescription: String,

    @field:NotBlank
    val userId: String,
)
