package com.zlrx.k8smscasestudy.controller

import com.zlrx.k8smscasestudy.domain.User
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController {

    @GetMapping("/user")
    fun getUsers(): List<User> {
        return listOf(User(1L, "Zalan"), User(2L, "Laura"))
    }

}
