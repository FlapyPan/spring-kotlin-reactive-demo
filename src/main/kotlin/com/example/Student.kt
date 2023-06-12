package com.example

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.annotation.Id
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.web.reactive.function.server.*

data class Student(@Id val id: Int?, val name: String, val age: Int)

interface StudentRepository : CoroutineCrudRepository<Student, Int>

@Configuration
class StudentController {
    @Bean
    fun router(
        @Autowired studentRepository: StudentRepository
    ) = coRouter {

        GET("/students") {
            ServerResponse.ok().bodyAndAwait(studentRepository.findAll())
        }

        GET("/students/{id}") {
            val id = it.pathVariable("id").toInt()
            studentRepository.findById(id)?.let { stu ->
                ServerResponse.ok().bodyValueAndAwait(stu)
            } ?: ServerResponse.notFound().buildAndAwait()
        }
    }
}
