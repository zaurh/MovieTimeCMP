package com.zaurh.movietimenew.domain.models.person.person_movies

import com.zaurh.movietimenew.util.ZERO_LONG

data class PersonMovies(
    val cast: List<PersonMoviesCastItem> = listOf(),
    val id: Long = ZERO_LONG
)