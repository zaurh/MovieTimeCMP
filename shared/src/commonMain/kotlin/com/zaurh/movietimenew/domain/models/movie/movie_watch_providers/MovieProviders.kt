package com.zaurh.movietimenew.domain.models.movie.movie_watch_providers

import com.zaurh.movietimenew.util.ZERO_LONG

data class MovieWatchProviders(
    val id: Long = ZERO_LONG,
    val results: Map<String, MovieWatchProvidersCountryItem> = mapOf()
)