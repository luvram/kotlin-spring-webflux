package me.luvram.kotlinspringwebflux

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController {
    @GetMapping
    suspend fun ping(): String {
        return "pong"
    }
}