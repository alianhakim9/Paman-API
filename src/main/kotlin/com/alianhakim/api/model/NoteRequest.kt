package com.alianhakim.api.model

import javax.validation.constraints.NotBlank

data class NoteRequest(
    @field:NotBlank
    val noteTitle: String?,

    @field:NotBlank
    val noteDescription: String?,

    val userId: String? = null
)
