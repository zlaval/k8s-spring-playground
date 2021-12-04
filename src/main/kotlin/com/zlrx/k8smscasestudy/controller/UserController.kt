package com.zlrx.k8smscasestudy.controller

import com.zlrx.k8smscasestudy.domain.User
import com.zlrx.k8smscasestudy.repository.UserRepository
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import kotlin.random.Random

@RestController
class UserController(
    private val repository: UserRepository
) {

//    @Value("\${test.name}")
//    val testName: String = ""

    private val random = Random(System.currentTimeMillis());

    //private val thirdId = random.nextInt(10, 1000);
    //private val forthId = random.nextInt(1000, 50000);
    private val logger = LoggerFactory.getLogger(javaClass)

    @GetMapping("/user")
    fun getUsers(): List<User> {
        logger.info("Request endpoint: /user")
        return repository.findAll()
//        return listOf(
//            User(1L, "Zalan"),
//            User(2L, "Laura"),
//            User(thirdId.toLong(), "Erik"),
//            User(forthId.toLong(), "Alex"),
//            User(5, testName)
//        )
    }

    @PostMapping("/user")
    fun postUser(@RequestBody user: User): User {
        return repository.save(user)
    }

}
