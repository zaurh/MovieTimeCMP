package com.zaurh.movietimenew.domain.models.movie.movie_credits

import com.zaurh.movietimenew.util.ZERO

data class MovieCredits(
    val id: Int = ZERO,
    val cast: List<MovieCreditsCast> = listOf()
)