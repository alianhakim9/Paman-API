package com.alianhakim.api.controller

import com.alianhakim.api.exception.ValidationErrorException
import com.alianhakim.api.model.PasswordManagerRequest
import com.alianhakim.api.model.PasswordManagerUpdateRequest
import com.alianhakim.api.service.impl.PasswordManagerServiceImpl
import com.alianhakim.api.utils.ResponseHandler.Companion.generatedResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.Errors
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.*
import javax.validation.ConstraintViolationException
import javax.validation.Valid

@RestController
@RequestMapping(path = ["/api/v1/password-manager/"])
class PasswordManagerController(
    @Autowired val pmService: PasswordManagerServiceImpl,
) {

    @PostMapping(consumes = ["application/json"], produces = ["application/json"])
    fun create(
        @Valid @RequestBody request: PasswordManagerRequest,
        error: Errors
    ): ResponseEntity<Any> {
        if (error.hasErrors()) throw ValidationErrorException(error.fieldErrors.toString())
        return generatedResponse(
            message = "create password manager",
            status = HttpStatus.OK,
            data = pmService.create(request)
        )
    }

    @GetMapping("{id}", produces = ["application/json"])
    fun get(
        @PathVariable("id") id: String
    ): ResponseEntity<Any> {
        return generatedResponse(
            message = "create password manager",
            status = HttpStatus.OK,
            data = pmService.get(id)
        )
    }

    @PutMapping("{id}", produces = ["application/json"], consumes = ["application/json"])
    fun update(
        @PathVariable("id") id: String,
        @Valid @RequestBody request: PasswordManagerUpdateRequest
    ): ResponseEntity<Any> {
        return generatedResponse(
            message = "update password manager",
            status = HttpStatus.OK,
            data = pmService.update(id, request)
        )
    }

    @DeleteMapping("{id}", produces = ["application/json"])
    fun delete(
        @PathVariable("id") id: String
    ): ResponseEntity<Any> {
        return generatedResponse(
            message = "delete password manager",
            status = HttpStatus.OK,
            data = pmService.delete(id)
        )
    }

    @GetMapping("/user/{userId}", produces = ["application/json"])
    fun getByUserId(
        @PathVariable("userId") userId: String
    ): ResponseEntity<Any> {
        return generatedResponse(
            message = "password manager by user id",
            status = HttpStatus.OK,
            data = pmService.getByUserId(userId)
        )
    }
}