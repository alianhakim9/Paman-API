package com.alianhakim.api.entity

import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Size

@Entity
@Table(
    uniqueConstraints = [UniqueConstraint(name = "note_title_unique)", columnNames = ["noteTitle"])]
)
data class Note(
    @field:NotBlank @field:NotEmpty @field:Size(max = 100) @field:Column(unique = true) var noteTitle: String,
    @field:NotBlank @field:NotEmpty @Lob var noteDescription: String,
    @field:ManyToOne(fetch = FetchType.EAGER) @field:JoinColumn(name = "user_id") val user: Users
) : BaseEntity()
