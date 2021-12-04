package com.zlrx.k8smscasestudy.domain

import javax.persistence.Basic
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table


@Table(name = "users")
@Entity
data class User(

    @Id
    @GeneratedValue
    var id: Long? = null,

    @Basic
    var name: String? = null
)


