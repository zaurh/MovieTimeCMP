package com.zaurh.movietimenew.data.models.tv.tv_watch_providers
import kotlinx.serialization.Serializable

@Serializable
data class TvWatchProvidersProviderDTO(
    val logo_path: String? = null,
    val provider_id: Int? = null,
    val provider_name: String? = null,
    val display_priority: Int? = null
)