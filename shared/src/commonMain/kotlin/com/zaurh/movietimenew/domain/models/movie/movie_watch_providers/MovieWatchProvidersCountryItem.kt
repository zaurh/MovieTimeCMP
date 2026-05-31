package com.zaurh.movietimenew.domain.models.movie.movie_watch_providers

import com.zaurh.movietimenew.util.EMPTY

data class MovieWatchProvidersCountryItem(
    val link: String = EMPTY,
    val flatrate: List<MovieWatchProvidersProvider> = listOf(),
    val rent: List<MovieWatchProvidersProvider> = listOf(),
    val buy: List<MovieWatchProvidersProvider> = listOf()
)