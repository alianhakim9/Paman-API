package com.alianhakim.api.utils

import com.alianhakim.api.exception.UserNotFoundException
import com.alianhakim.api.exception.ValidationErrorException
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.validation.ConstraintViolationException

@RestControllerAdvice
class ErrorController {

    @ExceptionHandler(UserNotFoundException::class)
    fun userNotFoundHandler(): ResponseEntity<Any> {
        return ResponseHandler.generatedResponse(
            message = "User not found",
            status = HttpStatus.NOT_FOUND,
            data = "NULL"
        )
    }

    @ExceptionHandler(value = [ValidationErrorException::class])
    fun validationHandler(e: ValidationErrorException): ResponseEntity<Any> {
        return ResponseHandler.generatedResponse(
            message = e.message.toString(),
            status = HttpStatus.BAD_REQUEST,
            data = "NULL"
        )
    }

    @ExceptionHandler(value = [NotFoundException::class])
    fun notFoundHandler(e: NotFoundException): ResponseEntity<Any> {
        return ResponseHandler.generatedResponse(
            message = "data not found",
            status = HttpStatus.NOT_FOUND,
            data = "NULL"
        )
    }
}