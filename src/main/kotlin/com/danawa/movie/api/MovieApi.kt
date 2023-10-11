package com.danawa.movie.api

import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1")
class MovieApi {

    @GetMapping("/")
    fun readMovie(): String {
        return "hello movie"
    }
}