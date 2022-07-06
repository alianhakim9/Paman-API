package com.alianhakim.api.entity

import javax.persistence.*
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Size

@Entity
@Table(
    uniqueConstraints = [UniqueConstraint(name = "email_unique)", columnNames = ["piEmail"])]
)
data class PersonalInfo(
    @field:NotBlank @field:NotEmpty @field:Size(max = 13) @field:Column(unique = true)
    var piPhoneNumber: String,

    @field:NotBlank @field:NotEmpty
    var piAddress: String,

    @field:NotBlank @field:NotEmpty @field:Size(max = 50)
    var piWebsite: String,

    @field:NotBlank @field:NotEmpty @field:Size(max = 100) @field:Email @field:Column(unique = true)
    var piEmail: String,

    @field:ManyToOne(fetch = FetchType.EAGER)
    @field:JoinColumn(name = "user_id")
    val user: Users
) : BaseEntity()
