package com.alianhakim.api.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class HomeController {
    @RequestMapping("/")
    fun index(): String {
        return "index.html"
    }

    @RequestMapping("error")
    fun error(): String {
        return "error page"
    }
}