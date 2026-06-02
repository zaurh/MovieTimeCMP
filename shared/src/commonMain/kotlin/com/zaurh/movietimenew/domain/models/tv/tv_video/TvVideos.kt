package com.zaurh.movietimenew.domain.models.tv.tv_video

import com.zaurh.movietimenew.util.ZERO
import kotlinx.serialization.Serializable

@Serializable
data class TvVideos(
    val id: Int = ZERO,
    val results: List<TvVideosItem> = listOf()
)

