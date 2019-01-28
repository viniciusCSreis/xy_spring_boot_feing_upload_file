package com.example.rwimgtest.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RestController
class Api{

    @GetMapping("/test2")
    fun teste2(@RequestParam("msg") msg:String): String{
        return "OI " + msg
    }

    @PostMapping("/test3")
    fun teste3(@RequestParam("file") multipartFile: MultipartFile): String{
        return "OI " + multipartFile.size
    }

}