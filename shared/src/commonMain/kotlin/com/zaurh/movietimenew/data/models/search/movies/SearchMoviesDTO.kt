package com.zaurh.movietimenew.data.models.search.movies

import kotlinx.serialization.Serializable

@Serializable
data class SearchMoviesDTO(
    val page: Int? = null,
    val results: List<SearchMovieItemDTO>? = null,
    val total_pages: Int? = null,
    val total_results: Int? = null
)