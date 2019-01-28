package com.example.demofeing.controller

import com.example.demofeing.feing.LocalApi
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RestController
class Api (private val localApi: LocalApi){

    @GetMapping("/teste")
    fun teste(@RequestParam("msg") msg:String) : String{
        return "Hello World: " + localApi.teste2(msg)
    }
    @PostMapping("/test2")
    fun teste3(@RequestParam("file") multipartFile: MultipartFile): String{
        println(multipartFile.originalFilename)
        return "OI " + "size:" + localApi.teste3(multipartFile)
    }


}