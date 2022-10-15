package com.miaodaye.app.view

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TestView {
    @RequestMapping("/test")
    fun test(){
        println("klklklkl")
    }
}