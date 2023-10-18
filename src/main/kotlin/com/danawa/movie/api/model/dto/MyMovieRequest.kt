package com.danawa.movie.api.model.dto

sealed class MyMovieRequest (
) {

    data class InsertRequest(
        val movieName: String,
        val movieCode: Long,
    )
}