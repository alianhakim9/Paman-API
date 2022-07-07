package com.alianhakim.api.service.impl

import com.alianhakim.api.entity.Users
import com.alianhakim.api.exception.InvalidPasswordException
import com.alianhakim.api.exception.UserNotFoundException
import com.alianhakim.api.model.AuthRequest
import com.alianhakim.api.repository.UsersRepository
import com.alianhakim.api.service.UserService
import com.alianhakim.api.utils.ValidationUtil
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserServiceImpl(
    private val validationUtil: ValidationUtil,
    private val repository: UsersRepository,
) : UserService {

    private val passwordEncoder = BCryptPasswordEncoder()

    override fun login(username: String, password: String): String {
        val user = repository.findByUsername(username).orElseThrow {
            UserNotFoundException()
        }
        val validatePassword = passwordEncoder.matches(password, user.password)
        if (!validatePassword) {
            throw InvalidPasswordException()
        }
//        val issuer = user.id.toString()
//        val jwt = Jwts.builder()
//            .setIssuer(issuer)
//            .setExpiration(Date(System.currentTimeMillis() + 60 * 24 * 1000))
//            .signWith(SignatureAlgorithm.HS512, "passmanager-secret-key")
//            .compact()

        /*
            val cookie = Cookie("jwt", jwt)
            cookie.isHttpOnly = true
            val response = HttpServletResponse()
            response.addCookie(cookie)
         */

        return user.id.toString()
    }

    override fun register(request: AuthRequest): String {
        validationUtil.validate(request)
        val newUsers = Users(
            username = request.username!!,
            password = passwordEncoder.encode(request.password!!)
        )
        newUsers.createdAt = Date()
        repository.save(newUsers)
        return newUsers.id.toString()
    }
}