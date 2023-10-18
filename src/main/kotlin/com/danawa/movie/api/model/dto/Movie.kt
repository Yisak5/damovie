package com.danawa.movie.api.model.dto

data class Movie(
    val movieCd: String,
    val movieNm: String,
    val movieNmEn: String,
    val prdtYear: String,
    val openDt: String,
    val typeNm: String,
    val prdtStatNm: String,
    val nationAlt: String,
    val genreAlt: String,
    val repNationNm: String,
    val repGenreNm: String,
    val directors: List<Director>?,
    val companys: List<Company>?
)