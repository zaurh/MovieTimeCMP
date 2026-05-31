package com.zaurh.movietimenew.data.models.movie.movie_watch_providers

import kotlinx.serialization.Serializable

@Serializable
data class MovieWatchProvidersCountryItemDTO(
    val link: String? = null,
    val flatrate: List<MovieWatchProvidersProviderDTO>? = null,
    val rent: List<MovieWatchProvidersProviderDTO>? = null,
    val buy: List<MovieWatchProvidersProviderDTO>? = null
)