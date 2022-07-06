package com.alianhakim.api.repository

import com.alianhakim.api.entity.Users
import org.springframework.data.jpa.repository.JpaRepository

interface UsersRepository : JpaRepository<Users, String> {
}