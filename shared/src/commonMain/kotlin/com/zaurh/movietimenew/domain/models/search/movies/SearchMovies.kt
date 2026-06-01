package com.zaurh.movietimenew.domain.models.search.movies

import com.zaurh.movietimenew.util.ZERO

data class SearchMovies(
    val page: Int = ZERO,
    val results: List<SearchMovieItem> = listOf(),
    val totalPages: Int = ZERO,
    val totalResults: Int = ZERO
)