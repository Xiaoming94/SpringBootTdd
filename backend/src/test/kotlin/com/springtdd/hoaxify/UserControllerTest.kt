package com.springtdd.hoaxify

import org.assertj.core.api.Assertions.assertThat

import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.test.context.ActiveProfiles
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.junit.jupiter.api.TestMethodOrder
import org.junit.jupiter.api.MethodOrderer
import kotlin.test.assertEquals
import kotlin.test.Test
import kotlin.test.BeforeTest

import com.springtdd.hoaxify.user.User;
import com.springtdd.hoaxify.user.UserRepository;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@TestMethodOrder(MethodOrderer.MethodName::class)
public class UserControllerTest {
    
    private val API_1_0_USER_PATH: String = "/api/1.0/users"
    @Autowired
    val testRestTemplate = TestRestTemplate()

    @Autowired
    lateinit var userRepository: UserRepository
    
    @BeforeTest
    public fun cleanup() {
        userRepository.deleteAll()
    }
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

    /**
     * INTEGRATION TEST
     * 
     * Given: A Valid user
     * When : Posting the user
     * Then : The user is saved to the Database 
     */
    @Test
    public fun postUser_whenUserIsValid_userSavedToDatabase() {
        val user = createValidUser()
        testRestTemplate.postForEntity(API_1_0_USER_PATH, user, Object::class.java)
        assertEquals(1, userRepository.count())
    }

    private fun createValidUser() = User("test-user", "test-display", "P4ssword")
}