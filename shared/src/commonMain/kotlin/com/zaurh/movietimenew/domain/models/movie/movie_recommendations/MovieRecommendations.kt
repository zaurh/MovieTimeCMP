package com.zaurh.movietimenew.domain.models.movie.movie_recommendations

import com.zaurh.movietimenew.util.ZERO

data class MovieRecommendations(
    val page: Int = ZERO,
    val results: List<MovieRecommendationsItem> = listOf(),
    val totalPages: Int = ZERO,
    val totalResults: Int = ZERO
)