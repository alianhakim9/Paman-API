package com.alianhakim.api.controller

import com.alianhakim.api.model.PersonalInfoRequest
import com.alianhakim.api.model.PersonalInfoUpdateRequest
import com.alianhakim.api.service.impl.PersonalInfoServiceImpl
import com.alianhakim.api.utils.ResponseHandler
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
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
            message = "create personal info", status = HttpStatus.OK, data = piService.create(request)
        )
    }

    @GetMapping("{id}", produces = ["application/json"])
    fun get(
        @PathVariable("id") id: String
    ): ResponseEntity<Any> {
        return ResponseHandler.generatedResponse(
            message = "create personal info", status = HttpStatus.OK, data = piService.get(id)
        )
    }

    @PutMapping("{id}", produces = ["application/json"], consumes = ["application/json"])
    fun update(
        @PathVariable("id") id: String, @Valid @RequestBody request: PersonalInfoUpdateRequest
    ): ResponseEntity<Any> {
        return ResponseHandler.generatedResponse(
            message = "update personal info", status = HttpStatus.OK, data = piService.update(id, request)
        )
    }

    @DeleteMapping("{id}", produces = ["application/json"])
    fun delete(
        @PathVariable("id") id: String
    ): ResponseEntity<Any> {
        piService.delete(id)
        return ResponseHandler.generatedResponse(
            message = "delete personal info", status = HttpStatus.OK, data = "DELETED"
        )
    }

    @GetMapping("/user/{userId}", produces = ["application/json"])
    fun getByUserId(
        @PathVariable("userId") userId: String
    ): ResponseEntity<Any> {
        return ResponseHandler.generatedResponse(
            message = "personal info by user id", status = HttpStatus.OK, data = piService.getByUserId(userId)
        )
    }
}