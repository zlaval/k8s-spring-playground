package com.zlrx.k8smscasestudy.controller

import com.zlrx.k8smscasestudy.domain.User
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import kotlin.random.Random

@RestController
class UserController {

    private val random = Random(System.currentTimeMillis());
    private val thirdId = random.nextInt(10, 1000);
    private val logger = LoggerFactory.getLogger(javaClass)

    @GetMapping("/user")
    fun getUsers(): List<User> {
        logger.info("/user request received")
        return listOf(User(1L, "Zalan"), User(2L, "Laura"), User(thirdId.toLong(), "Erik"))
    }

}
