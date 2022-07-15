package com.alianhakim.api.controller

import com.alianhakim.api.exception.ValidationErrorException
import com.alianhakim.api.model.NoteRequest
import com.alianhakim.api.model.NoteUpdateRequest
import com.alianhakim.api.service.impl.NoteServiceImpl
import com.alianhakim.api.utils.ResponseHandler
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.Errors
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping(path = ["/api/v1/note/"])
class NoteController(
    @Autowired val noteService: NoteServiceImpl,
) {
    @PostMapping(consumes = ["application/json"], produces = ["application/json"])
    fun create(
        @Valid @RequestBody request: NoteRequest,
    ): ResponseEntity<Any> {
        return ResponseHandler.generatedResponse(
            message = "create note", status = HttpStatus.OK, data = noteService.create(request)
        )
    }

    @GetMapping("{id}", produces = ["application/json"])
    fun get(
        @PathVariable("id") id: String
    ): ResponseEntity<Any> {
        return ResponseHandler.generatedResponse(
            message = "create note", status = HttpStatus.OK, data = noteService.get(id)
        )
    }

    @PutMapping("{id}", produces = ["application/json"], consumes = ["application/json"])
    fun update(
        @PathVariable("id") id: String, @Valid @RequestBody request: NoteUpdateRequest
    ): ResponseEntity<Any> {
        return ResponseHandler.generatedResponse(
            message = "update note", status = HttpStatus.OK, data = noteService.update(id, request)
        )
    }

    @DeleteMapping("{id}", produces = ["application/json"])
    fun delete(
        @PathVariable("id") id: String
    ): ResponseEntity<Any> {
        noteService.delete(id)
        return ResponseHandler.generatedResponse(
            message = "delete note", status = HttpStatus.OK, data = "DELETED"
        )
    }

    @GetMapping("/user/{userId}", produces = ["application/json"])
    fun getByUserId(
        @PathVariable("userId") userId: String
    ): ResponseEntity<Any> {
        return ResponseHandler.generatedResponse(
            message = "note by user id", status = HttpStatus.OK, data = noteService.getByUserId(userId)
        )
    }
}