package com.alianhakim.api.repository

import com.alianhakim.api.entity.Note
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface NoteRepository : JpaRepository<Note, String> {
    @Query(
        "select * from note where user_id=:user_id", nativeQuery = true
    )
    fun findByUserId(@Param("user_id") userId: String): List<Note>
}