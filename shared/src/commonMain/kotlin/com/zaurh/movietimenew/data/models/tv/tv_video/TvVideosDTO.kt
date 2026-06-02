package com.zaurh.movietimenew.data.models.tv.tv_video

import kotlinx.serialization.Serializable

@Serializable
data class TvVideosDTO(
    val id: Int? = null,
    val results: List<TvVideosItemDTO>? = null
)

