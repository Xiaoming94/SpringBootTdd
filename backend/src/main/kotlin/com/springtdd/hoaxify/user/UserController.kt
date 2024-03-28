package com.springtdd.hoaxify.user

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.beans.factory.annotation.Autowired

@RestController
public class UserController {

    @Autowired
    lateinit var userService: UserService

    @PostMapping("/api/1.0/users")
    fun createUser(@RequestBody user: User) {
        userService.save(user)
    }
}