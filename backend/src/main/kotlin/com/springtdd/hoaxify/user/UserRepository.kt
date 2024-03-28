package com.springtdd.hoaxify.user;

import org.springframework.data.jpa.repository.JpaRepository

public interface UserRepository : JpaRepository<User, Long> {}