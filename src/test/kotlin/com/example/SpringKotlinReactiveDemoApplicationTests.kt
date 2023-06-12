package com.example

import kotlinx.coroutines.flow.count
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class SpringKotlinReactiveDemoApplicationTests(
    @Autowired val studentRepository: StudentRepository
) {

    @Test
    fun contextLoads() {
        runBlocking {
            studentRepository.save(Student(null, "测试", 20))
            val studentFlow = studentRepository.findAll()
            Assertions.assertEquals(4, studentFlow.count())
        }
    }

}
