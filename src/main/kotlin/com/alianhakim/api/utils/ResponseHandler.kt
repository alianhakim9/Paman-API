package com.alianhakim.api.utils

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

class ResponseHandler {
    companion object {
        fun generatedResponse(
            message: String,
            status: HttpStatus,
            data: Any
        ): ResponseEntity<Any> {
            val map: HashMap<String, Any> = HashMap()
            map["message"] = message
            map["status"] = status
            map["data"] = data
            return ResponseEntity<Any>(map, status)
        }
    }
}