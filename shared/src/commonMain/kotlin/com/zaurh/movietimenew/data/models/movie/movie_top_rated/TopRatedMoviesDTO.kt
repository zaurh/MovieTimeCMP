package com.zaurh.movietimenew.data.models.movie.movie_top_rated

import kotlinx.serialization.Serializable

@Serializable
data class TopRatedMoviesDTO(
    val page: Int? = null,
    val results: List<TopRatedMoviesItemDTO>? = null,
    val total_pages: Int? = null,
    val total_results: Int? = null
)