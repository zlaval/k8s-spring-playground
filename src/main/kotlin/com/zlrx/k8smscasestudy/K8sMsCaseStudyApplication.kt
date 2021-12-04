package com.zlrx.k8smscasestudy

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication//(exclude = [DataSourceAutoConfiguration::class])
class K8sMsCaseStudyApplication

fun main(args: Array<String>) {
    runApplication<K8sMsCaseStudyApplication>(*args)
}
