package com.alianhakim.api.repository

import com.alianhakim.api.entity.Users
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import java.util.Optional

interface UsersRepository : JpaRepository<Users, String> {
    //    @Query("select p from users p where p.username=:username", nativeQuery = true)
    fun findByUsername(@Param("username") username: String): Optional<Users>
}