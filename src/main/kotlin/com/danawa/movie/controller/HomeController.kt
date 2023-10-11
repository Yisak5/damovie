package com.danawa.movie.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/home")
class HomeController {

    @GetMapping("/")
    fun index(model: Model):String {
        model.addAttribute("greeting", "Hello Thymeleaf!")
        return "index"
    }
}