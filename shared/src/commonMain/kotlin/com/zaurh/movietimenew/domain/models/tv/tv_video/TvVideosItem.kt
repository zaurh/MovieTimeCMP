package com.zaurh.movietimenew.domain.models.tv.tv_video

import com.zaurh.movietimenew.util.EMPTY
import com.zaurh.movietimenew.util.ZERO
import kotlinx.serialization.Serializable

@Serializable
data class TvVideosItem(
    val languageCode: String = EMPTY,
    val countryCode: String = EMPTY,
    val name: String = EMPTY,
    val key: String = EMPTY,
    val site: String = EMPTY,
    val size: Int = ZERO,
    val type: String = EMPTY,
    val official: Boolean = false,
    val publishedAt: String = EMPTY,
    val id: String = EMPTY
)