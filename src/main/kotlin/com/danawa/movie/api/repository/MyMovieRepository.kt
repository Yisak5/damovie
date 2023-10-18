package com.danawa.movie.api.repository

import com.danawa.movie.api.model.entity.MyMovie

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MyMovieRepository : JpaRepository<MyMovie?, Long?> {
}