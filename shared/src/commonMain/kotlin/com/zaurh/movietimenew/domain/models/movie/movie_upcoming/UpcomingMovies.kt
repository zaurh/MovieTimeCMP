package com.zaurh.movietimenew.domain.models.movie.movie_upcoming

import com.zaurh.movietimenew.util.ZERO

data class UpcomingMovies(
    val dates: UpcomingMoviesDates = UpcomingMoviesDates(),
    val page: Int = ZERO,
    val results: List<UpcomingMoviesItem> = listOf(),
    val totalPages: Int = ZERO,
    val totalResults: Int = ZERO
)