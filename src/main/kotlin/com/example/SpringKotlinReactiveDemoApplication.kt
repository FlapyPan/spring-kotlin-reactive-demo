package com.example

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringKotlinReactiveDemoApplication

fun main(args: Array<String>) {
    runApplication<SpringKotlinReactiveDemoApplication>(*args)
}
