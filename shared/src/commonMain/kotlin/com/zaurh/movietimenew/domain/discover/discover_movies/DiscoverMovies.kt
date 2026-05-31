package com.zaurh.movietimenew.domain.discover.discover_movies

import com.zaurh.movietimenew.util.ZERO

data class DiscoverMovies(
    val page: Int = ZERO,
    val results: List<DiscoverMoviesItem> = listOf(),
    val totalPages: Int = ZERO,
    val totalResults: Int = ZERO
)