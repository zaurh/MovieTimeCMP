package com.zaurh.movietimenew.data.models.tv.tv_watch_providers
import kotlinx.serialization.Serializable

@Serializable
data class TvWatchProvidersDTO(
    val id: Long? = null,
    val results: Map<String, TvWatchProvidersCountryItemDTO>? = null
)