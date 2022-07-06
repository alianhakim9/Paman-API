package com.alianhakim.api.model

import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

data class PersonalInfoRequest(
    @field:NotBlank
    val piAddress: String?,

    @field:NotBlank
    @field:Email
    val piEmail: String?,

    @field:NotBlank
    @field:Size(max = 13)
    val piPhoneNumber: String?,

    @field:NotBlank
    val piWebsite: String?,

    @field:NotBlank
    val userId: String?
)
