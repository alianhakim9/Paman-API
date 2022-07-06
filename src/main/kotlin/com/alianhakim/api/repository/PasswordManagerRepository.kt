package com.alianhakim.api.repository

import com.alianhakim.api.entity.PasswordManager
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface PasswordManagerRepository : JpaRepository<PasswordManager, String> {
    @Query(
        "select * from password_manager where user_id=:user_id", nativeQuery = true
    )
    fun findByUserId(@Param("user_id") userId: String): List<PasswordManager>
}