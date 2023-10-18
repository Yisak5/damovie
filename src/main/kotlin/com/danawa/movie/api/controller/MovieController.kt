package com.danawa.movie.api.controller

import com.danawa.movie.api.model.entity.MyMovie
import com.danawa.movie.api.model.dto.Movie
import com.danawa.movie.api.model.dto.MyMovieRequest
import com.danawa.movie.api.service.MovieService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/movies")
class MovieController(private val movieService: MovieService) {

    @GetMapping("/search")
    fun searchMovies(
        @RequestParam("openStartDt") openStartDt: String,
        @RequestParam("page") page: Int
    ): List<Movie> {
        return movieService.searchMovies(openStartDt, page)
    }

    @GetMapping("/my/{id}")
    fun getMovieById(@PathVariable id: Long): ResponseEntity<Any> {
        val movie = movieService.readById(id)
        return ResponseEntity(movie ?: HttpStatus.NOT_FOUND, if (movie != null) HttpStatus.OK else HttpStatus.NOT_FOUND)
    }

    @PostMapping("/my")
    fun createMovie(@RequestBody insertMyMovie: MyMovieRequest.InsertRequest): ResponseEntity<MyMovie> {
        val myMovie = MyMovie(
            movieCode = insertMyMovie.movieCode,
            movieName = insertMyMovie.movieName
        )

        val createdMovie = movieService.create(myMovie)
        return ResponseEntity(createdMovie, HttpStatus.CREATED)
    }

    @DeleteMapping("/my/{id}")
    fun deleteMovie(@PathVariable id: Long): ResponseEntity<Void> {
        movieService.delete(id)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }


}