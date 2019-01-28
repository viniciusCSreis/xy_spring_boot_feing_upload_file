package com.example.demofeing

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
class DemoFeingApplication

fun main(args: Array<String>) {
    runApplication<DemoFeingApplication>(*args)
}

