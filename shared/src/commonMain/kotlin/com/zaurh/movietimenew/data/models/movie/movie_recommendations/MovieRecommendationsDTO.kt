package com.zaurh.movietimenew.data.models.movie.movie_recommendations

import kotlinx.serialization.Serializable

@Serializable
data class MovieRecommendationsDTO(
    val page: Int? = null,
    val results: List<MovieRecommendationsItemDTO>? = null,
    val total_pages: Int? = null,
    val total_results: Int? = null
)