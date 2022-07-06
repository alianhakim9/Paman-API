package com.alianhakim.api.service.impl

import com.alianhakim.api.entity.Users
import com.alianhakim.api.exception.InvalidPasswordException
import com.alianhakim.api.model.AuthRequest
import com.alianhakim.api.model.AuthResponse
import com.alianhakim.api.repository.UsersRepository
import com.alianhakim.api.service.UserService
import com.alianhakim.api.utils.Helper
import com.alianhakim.api.utils.ValidationUtil
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import java.util.*
import javax.servlet.http.Cookie

@Service
class UserServiceImpl(
    private val validationUtil: ValidationUtil,
    private val repository: UsersRepository,
    private val helper: Helper
) : UserService {

    private val passwordEncoder = BCryptPasswordEncoder()

    override fun login(username: String, password: String): AuthResponse {
        val user = repository.findByUsername(username)
        helper.userNotFound(user)
        val validatePassword = passwordEncoder.matches(password, user.get().password)
        if (!validatePassword) {
            throw InvalidPasswordException()
        }
        val issuer = user.get().id.toString()
        val jwt = Jwts.builder()
            .setIssuer(issuer)
            .setExpiration(Date(System.currentTimeMillis() + 60 * 24 * 1000))
            .signWith(SignatureAlgorithm.HS512, "passmanager-secret-key")
            .compact()

        /*
            val cookie = Cookie("jwt", jwt)
            cookie.isHttpOnly = true
            val response = HttpServletResponse()
            response.addCookie(cookie)
         */

        return AuthResponse(
            userId = user.get().id.toString(),
            token = jwt
        )
    }

    override fun register(request: AuthRequest): AuthResponse {
        validationUtil.validate(request)
        val newUsers = Users(
            username = request.username!!,
            password = passwordEncoder.encode(request.password!!)
        )
        newUsers.createdAt = Date()
        repository.save(newUsers)
        validationUtil.validate(repository.save(newUsers))
        return AuthResponse(
            userId = newUsers.id.toString(),
            token = "Bearer"
        )
    }
}