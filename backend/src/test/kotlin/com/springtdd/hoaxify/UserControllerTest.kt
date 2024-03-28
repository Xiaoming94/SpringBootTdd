package com.springtdd.hoaxify

import org.assertj.core.api.Assertions.assertThat

import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.test.context.ActiveProfiles
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import kotlin.test.assertEquals
import kotlin.test.Test

import com.springtdd.hoaxify.user.User;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class UserControllerTest {
    
    private val API_1_0_USER_PATH: String = "/api/1.0/users"
    @Autowired
    val testRestTemplate = TestRestTemplate()

    /**
     * INTEGRATION TEST
     * 
     * Given: A Valid user
     * When : Posting the user
     * Then : Receive Ok from server 
     */
    @Test
    public fun postUser_whenUserIsValid_receiveOk() {
        val user = createValidUser() 
        val response = testRestTemplate.postForEntity(API_1_0_USER_PATH, user, Object::class.java)
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK)
    }

    private fun createValidUser() = User("test-user", "test-display", "P4ssword")
}