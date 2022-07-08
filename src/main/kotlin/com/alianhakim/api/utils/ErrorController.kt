package com.alianhakim.api.utils

import com.alianhakim.api.exception.InvalidPasswordException
import com.alianhakim.api.exception.UnAuthorizedException
import com.alianhakim.api.exception.UserNotFoundException
import com.alianhakim.api.exception.ValidationErrorException
import com.alianhakim.api.utils.ResponseHandler.Companion.generatedResponse
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.sql.SQLException
import java.sql.SQLIntegrityConstraintViolationException
import javax.validation.ConstraintViolationException

@RestControllerAdvice
class ErrorController {

    @ExceptionHandler(UserNotFoundException::class)
    fun userNotFoundHandler(): ResponseEntity<Any> {
        return generatedResponse(
            message = "User not found", status = HttpStatus.NOT_FOUND, data = "NULL"
        )
    }

    @ExceptionHandler(value = [ConstraintViolationException::class])
    fun validationHandler(e: ConstraintViolationException): ResponseEntity<Any> {
        return generatedResponse(
            message = e.message.toString(), status = HttpStatus.BAD_REQUEST, data = "NULL"
        )
    }

    @ExceptionHandler(value = [NotFoundException::class])
    fun notFoundHandler(e: NotFoundException): ResponseEntity<Any> {
        return generatedResponse(
            message = "data not found", status = HttpStatus.NOT_FOUND, data = "NULL"
        )
    }

    @ExceptionHandler(value = [InvalidPasswordException::class])
    fun invalidPasswordHandler(): ResponseEntity<Any> {
        return generatedResponse(
            message = "invalid password", status = HttpStatus.BAD_REQUEST, data = "NULL"
        )
    }

    @ExceptionHandler(value = [UnAuthorizedException::class])
    fun unAuthorizedHandler(): ResponseEntity<Any> {
        return generatedResponse(
            message = "unauthorized", status = HttpStatus.UNAUTHORIZED, data = "NULL"
        )
    }

    @ExceptionHandler(value = [SQLException::class])
    fun sqlException(e: SQLException): ResponseEntity<Any> {
        return generatedResponse(
            message = e.message.toString(), status = HttpStatus.CONFLICT, data = "NULL"
        )
    }
}