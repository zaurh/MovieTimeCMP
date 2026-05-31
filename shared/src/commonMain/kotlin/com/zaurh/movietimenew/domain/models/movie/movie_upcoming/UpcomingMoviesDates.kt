package com.zaurh.movietimenew.domain.models.movie.movie_upcoming

import com.zaurh.movietimenew.util.EMPTY

data class UpcomingMoviesDates(
    val maximum: String = EMPTY,
    val minimum: String = EMPTY
)