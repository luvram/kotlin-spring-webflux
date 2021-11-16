package me.luvram.kotlinspringwebflux

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(
    private val userService: UserService
) {
    @GetMapping
    suspend fun ping(): String {
        return "pong"
    }

    @PostMapping
    suspend fun save(@RequestBody userRequest: UserRequest) {
        userService.save(userRequest)
    }
}
