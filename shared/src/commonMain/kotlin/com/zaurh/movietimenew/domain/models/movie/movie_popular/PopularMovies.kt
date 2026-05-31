package com.zaurh.movietimenew.domain.models.movie.movie_popular

import com.zaurh.movietimenew.util.ZERO

data class PopularMovies(
    val page: Int = ZERO,
    val results: List<PopularMoviesItem> = listOf(),
    val totalPages: Int = ZERO,
    val totalResults: Int = ZERO
)