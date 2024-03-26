package com.springtdd.hoaxify

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class HoaxifyApplication

fun main(args: Array<String>) {
	runApplication<HoaxifyApplication>(*args)
}
