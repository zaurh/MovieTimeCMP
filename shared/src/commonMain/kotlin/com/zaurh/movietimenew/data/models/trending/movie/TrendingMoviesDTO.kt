package com.zaurh.movietimenew.data.models.trending.movie

import kotlinx.serialization.Serializable

@Serializable
data class TrendingMoviesDTO(
    val page: Int? = null,
    val results: List<TrendingMoviesItemDTO>? = null,
    val total_pages: Int? = null,
    val total_results: Int? = null
)