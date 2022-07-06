package com.alianhakim.api.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table
import javax.persistence.UniqueConstraint
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Size

@Entity
@Table(
    uniqueConstraints = [UniqueConstraint(name = "username_unique)", columnNames = ["username"])]
)
data class Users(
    @field:NotBlank
    @field:NotEmpty
    @Size(max = 50)
    @field:Column(unique = true)
    val username: String,

    @field:NotBlank
    @field:NotEmpty
    val password: String,
) : BaseEntity()
