package com.zaurh.movietimenew.data.models.tv.tv_watch_providers
import kotlinx.serialization.Serializable

@Serializable
data class TvWatchProvidersCountryItemDTO(
    val link: String? = null,
    val flatrate: List<TvWatchProvidersProviderDTO>? = null,
    val rent: List<TvWatchProvidersProviderDTO>? = null,
    val buy: List<TvWatchProvidersProviderDTO>? = null
)