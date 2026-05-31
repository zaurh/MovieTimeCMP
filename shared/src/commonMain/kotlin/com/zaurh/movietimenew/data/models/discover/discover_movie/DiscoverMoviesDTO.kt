package com.zaurh.movietimenew.data.models.discover.discover_movie

import kotlinx.serialization.Serializable

@Serializable
data class DiscoverMoviesDTO(
    val page: Int? = null,
    val results: List<DiscoverMoviesItemDTO>? = null,
    val total_pages: Int? = null,
    val total_results: Int? = null
)