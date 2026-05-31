package com.zaurh.movietimenew.data.models.movie.movie_popular

import kotlinx.serialization.Serializable

@Serializable
data class PopularMoviesDTO(
    val page: Int,
    val results: List<PopularMoviesItemDTO>,
    val total_pages: Int,
    val total_results: Int
)