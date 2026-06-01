package com.zaurh.movietimenew.domain.models.trending.movie
import com.zaurh.movietimenew.util.ZERO

data class TrendingMovies(
    val page: Int = ZERO,
    val results: List<TrendingMoviesItem> = listOf(),
    val totalPages: Int = ZERO,
    val totalResults: Int = ZERO
)