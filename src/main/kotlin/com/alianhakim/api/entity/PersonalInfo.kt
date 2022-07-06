package com.alianhakim.api.entity

import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Size

@Entity
data class PersonalInfo(
    @field:NotBlank @field:NotEmpty @field:Size(max = 13)
    var piPhoneNumber: String,

    @field:NotBlank @field:NotEmpty
    var piAddress: String,

    @field:NotBlank @field:NotEmpty @field:Size(max = 50)
    var piWebsite: String,

    @field:NotBlank @field:NotEmpty @field:Size(max = 100) @field:Email
    var piEmail: String,

    @field:ManyToOne(fetch = FetchType.EAGER)
    @field:JoinColumn(name = "user_id")
    val user: Users
) : BaseEntity()
