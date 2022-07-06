package com.alianhakim.api.entity

import javax.persistence.Entity
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Size

@Entity
data class Users(
    @field:NotBlank
    @field:NotEmpty
    @Size(max = 50)
    val username: String,

    @field:NotBlank
    @field:NotEmpty
    val password: String,
) : BaseEntity()
