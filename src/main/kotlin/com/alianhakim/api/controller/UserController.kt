package com.alianhakim.api.controller

import com.alianhakim.api.model.AuthRequest
import com.alianhakim.api.service.impl.UserServiceImpl
import com.alianhakim.api.utils.ResponseHandler
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping(path = ["/api/v1/auth/"])
class UserController(
    @Autowired val service: UserServiceImpl
) {

    @PostMapping("/login", produces = ["application/json"], consumes = ["application/json"])
    fun login(
        @Valid
        @RequestBody authRequest: AuthRequest
    ): ResponseEntity<Any> {
        return ResponseHandler.generatedResponse(
            message = "login success",
            status = HttpStatus.OK,
            data = service.login(authRequest.username!!, authRequest.password!!)
        )
    }

    @PostMapping("/register", produces = ["application/json"], consumes = ["application/json"])
    fun register(
        @Valid
        @RequestBody authRequest: AuthRequest,
    ): ResponseEntity<Any> {
        return ResponseHandler.generatedResponse(
            message = "register success",
            status = HttpStatus.OK,
            data = service.register(authRequest)
        )
    }
}