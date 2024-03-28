package com.springtdd.hoaxify.user;

import org.springframework.stereotype.Service

@Service
public class UserService(var userRepository: UserRepository) {

    public fun save(user: User): User {
        return userRepository.save(user)
    }
}