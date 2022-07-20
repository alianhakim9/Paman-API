package com.alianhakim.api.entity

import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Size

@Entity
data class Note(
    @field:NotBlank @field:NotEmpty @field:Size(max = 100) var noteTitle: String,
    @field:NotBlank @field:NotEmpty var noteDescription: String,
    @field:ManyToOne(fetch = FetchType.EAGER) @field:JoinColumn(name = "user_id") val user: Users
) : BaseEntity()
