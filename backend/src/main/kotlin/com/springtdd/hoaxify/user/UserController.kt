package com.springtdd.hoaxify.user

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.PostMapping

@RestController
public class UserController {

    @PostMapping("/api/1.0/users")
    fun createUser() {

    }
}