package com.zaurh.movietimenew.data.models.movie.movie_watch_providers

import kotlinx.serialization.Serializable

@Serializable
data class MovieWatchProvidersDTO(
    val id: Long? = null,
    val results: Map<String, MovieWatchProvidersCountryItemDTO>? = null
)