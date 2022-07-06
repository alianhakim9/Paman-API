package com.alianhakim.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication(exclude = [SecurityAutoConfiguration::class])
class PamanApiApplication

fun main(args: Array<String>) {
    runApplication<PamanApiApplication>(*args)
}
