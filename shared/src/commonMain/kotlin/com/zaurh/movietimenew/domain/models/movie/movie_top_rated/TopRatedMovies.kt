package com.zaurh.movietimenew.domain.models.movie.movie_top_rated

import com.zaurh.movietimenew.util.ZERO

data class TopRatedMovies(
    val page: Int = ZERO,
    val results: List<TopRatedMoviesItem> = listOf(),
    val totalPages: Int = ZERO,
    val totalResults: Int = ZERO
)