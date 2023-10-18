package com.danawa.movie.api.service

import com.danawa.movie.api.model.entity.MyMovie
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
@Transactional
class MyMovieServiceTest {

    @Autowired
    private lateinit var movieService: MovieService

    @Test
    fun createMovieTest() {
        val movie = MyMovie(movieCode = 1, movieName = "가고일")
        val createdMovie = movieService.create(movie)

        assertNotNull(createdMovie.id)
        assertEquals(1, createdMovie.movieCode)
        assertEquals("가고일", createdMovie.movieName)
    }

    @Test
    fun deleteMovieTest() {
        movieService.delete(1)
    }
}