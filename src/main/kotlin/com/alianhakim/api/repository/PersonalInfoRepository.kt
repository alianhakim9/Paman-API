package com.alianhakim.api.repository

import com.alianhakim.api.entity.PersonalInfo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface PersonalInfoRepository : JpaRepository<PersonalInfo, String> {
    @Query(
        "select * from personal_info where user_id=:user_id", nativeQuery = true
    )
    fun findByUserId(@Param("user_id") userId: String): List<PersonalInfo>
}