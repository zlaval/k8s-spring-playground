package com.zlrx.k8smscasestudy.repository

import com.zlrx.k8smscasestudy.domain.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {


}
