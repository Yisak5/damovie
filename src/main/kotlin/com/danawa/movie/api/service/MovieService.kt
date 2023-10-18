package com.danawa.movie.api.service

import com.danawa.movie.api.model.entity.MyMovie
import com.danawa.movie.api.repository.MyMovieRepository
import com.danawa.movie.api.model.dto.MovieApiResponse
import com.danawa.movie.api.model.dto.Movie
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class MovieService(private val myMovieRepository: MyMovieRepository) {

    // 영화진흥원 API 영화 검색
    fun searchMovies(openStartDt: String, page: Int): List<Movie> {
        val apiKey = "e970c123e754587f439585b71e2baf0c"
        val url = "https://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieList.json?key=$apiKey&openStartDt=$openStartDt&curPage=$page"
        val restTemplate = RestTemplate()
        val response = restTemplate.getForObject(url, MovieApiResponse::class.java)
        return response?.movieListResult?.movieList.orEmpty()
    }

    fun create(myMovie: MyMovie): MyMovie {
        return myMovieRepository.save(myMovie)
    }

    fun readById(id: Long): MyMovie? {
        return myMovieRepository.findById(id).orElse(null)
    }

    fun delete(id: Long) {
        myMovieRepository.deleteById(id)
    }
}

data class MovieListResult(
    val movieList: List<Movie>
)