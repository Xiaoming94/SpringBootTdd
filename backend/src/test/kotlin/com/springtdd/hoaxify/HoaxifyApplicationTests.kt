package com.springtdd.hoaxify

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import kotlin.test.assertEquals

@SpringBootTest
class HoaxifyApplicationTests {

	@Test
	fun contextLoads() {
	}

	@Test
	fun testEquals() {
		var a = 10
		assertEquals(10, a)
	}

}
