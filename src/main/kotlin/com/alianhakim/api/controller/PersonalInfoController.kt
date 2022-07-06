package com.alianhakim.api.controller

import com.alianhakim.api.exception.ValidationErrorException
import com.alianhakim.api.model.PersonalInfoRequest
import com.alianhakim.api.model.PersonalInfoUpdateRequest
import com.alianhakim.api.service.impl.PersonalInfoServiceImpl
import com.alianhakim.api.utils.ResponseHandler
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.Errors
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping(path = ["/api/v1/personal-info/"])
class PersonalInfoController(
    @Autowired val piService: PersonalInfoServiceImpl,
) {
    @PostMapping(consumes = ["application/json"], produces = ["application/json"])
    fun create(
        @Valid @RequestBody request: PersonalInfoRequest,
    ): ResponseEntity<Any> {
        return ResponseHandler.generatedResponse(
            message = "create password manager",
            status = HttpStatus.OK,
            data = piService.create(request)
        )
    }

    @GetMapping("{id}", produces = ["application/json"])
    fun get(
        @PathVariable("id") id: String
    ): ResponseEntity<Any> {
        return ResponseHandler.generatedResponse(
            message = "create password manager",
            status = HttpStatus.OK,
            data = piService.get(id)
        )
    }

    @PutMapping("{id}", produces = ["application/json"], consumes = ["application/json"])
    fun update(
        @PathVariable("id") id: String,
        @Valid @RequestBody request: PersonalInfoUpdateRequest
    ): ResponseEntity<Any> {
        return ResponseHandler.generatedResponse(
            message = "update password manager",
            status = HttpStatus.OK,
            data = piService.update(id, request)
        )
    }

    @DeleteMapping("{id}", produces = ["application/json"])
    fun delete(
        @PathVariable("id") id: String
    ): ResponseEntity<Any> {
        return ResponseHandler.generatedResponse(
            message = "delete password manager",
            status = HttpStatus.OK,
            data = piService.delete(id)
        )
    }

    @GetMapping("/user/{userId}", produces = ["application/json"])
    fun getByUserId(
        @PathVariable("userId") userId: String
    ): ResponseEntity<Any> {
        return ResponseHandler.generatedResponse(
            message = "password manager by user id",
            status = HttpStatus.OK,
            data = piService.getByUserId(userId)
        )
    }
}