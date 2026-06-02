package com.zaurh.movietimenew.domain.models.tv.tv_watch_providers

import com.zaurh.movietimenew.util.EMPTY

data class TvWatchProvidersCountryItem(
    val link: String = EMPTY,
    val flatrate: List<TvWatchProvidersProvider> = listOf(),
    val rent: List<TvWatchProvidersProvider> = listOf(),
    val buy: List<TvWatchProvidersProvider> = listOf()
)