package com.zaurh.movietimenew.domain.models.tv.tv_watch_providers

import com.zaurh.movietimenew.util.ZERO_LONG

data class TvWatchProviders(
    val id: Long = ZERO_LONG,
    val results: Map<String, TvWatchProvidersCountryItem> = mapOf()
)