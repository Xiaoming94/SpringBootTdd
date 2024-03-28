package com.springtdd.hoaxify.user

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Table

@Entity 
@Table(name="users")
data class User(
    val userName: String = "",
    val displayName: String = "",
    val password: String = ""
) {
    @Id
    @GeneratedValue
    var id: Long = 0

}