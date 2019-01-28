package com.example.demofeing.feing

import feign.Contract
import feign.Feign
import feign.codec.Decoder
import feign.form.spring.SpringFormEncoder
import org.springframework.beans.factory.ObjectFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.http.HttpMessageConverters
import org.springframework.cloud.openfeign.FeignClientsConfiguration
import org.springframework.cloud.openfeign.support.SpringEncoder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RequestPart
import org.springframework.web.multipart.MultipartFile
import java.io.IOException


@Configuration
@Import(FeignClientsConfiguration::class)
class FeingConfig{

    @Autowired
    private val messageConverters: ObjectFactory<HttpMessageConverters>? = null


    @Bean
    fun testApi(decoder: Decoder,  contract : Contract) : LocalApi{
        return  Feign.builder()
                .encoder(SpringFormEncoder(SpringEncoder(messageConverters)))
                .decoder(decoder)
                .contract(contract)
                .target(LocalApi::class.java, "http://localhost:8081/")

    }
}

interface LocalApi{

    @GetMapping("/test2")
    fun teste2(@RequestParam("msg") msg:String): String

    @PostMapping("/test3", consumes = [MULTIPART_FORM_DATA_VALUE])
    @Throws(IOException::class)
    fun teste3(@RequestPart("file", required = true) multipartFile: MultipartFile): String


}