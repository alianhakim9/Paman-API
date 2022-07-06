package com.alianhakim.api.model

import javax.validation.constraints.NotBlank

data class PasswordManagerRequest(
    @field:NotBlank
    val pmUsername: String?,
    @field:NotBlank
    val pmPassword: String?,
    @field:NotBlank
    val pmWebsite: String?,
    @field:NotBlank
    val userId: String?
)
