package com.alianhakim.api.model

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty

data class PasswordManagerUpdateRequest(
    @NotBlank
    @NotEmpty
    val pmUsername: String,
    @NotBlank
    @NotEmpty
    val pmPassword: String,
    @NotBlank
    @NotEmpty
    val pmWebsite: String,
    val userId: String? = null
)
