package com.zlrx.k8smscasestudy.controller

import com.zlrx.k8smscasestudy.domain.User
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import kotlin.random.Random

@RestController
class UserController {

    @Value("\${test.name}")
    val testName: String = ""

    private val random = Random(System.currentTimeMillis());
    private val thirdId = random.nextInt(10, 1000);
    private val forthId = random.nextInt(1000, 50000);
    private val logger = LoggerFactory.getLogger(javaClass)

    @GetMapping("/user")
    fun getUsers(): List<User> {
        logger.info("Request endpoint: /user")
        return listOf(
            User(1L, "Zalan"),
            User(2L, "Laura"),
            User(thirdId.toLong(), "Erik"),
            User(forthId.toLong(), "Alex"),
            User(5, testName)
        )
    }

}
