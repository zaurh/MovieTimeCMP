package com.zaurh.movietimenew.domain.models.tv.tv_image

import com.zaurh.movietimenew.util.ZERO_LONG

data class TvImages(
    val backdrops: List<TvImagesItem> = listOf(),
    val id: Long = ZERO_LONG,
    val logos: List<TvImagesItem> = listOf(),
    val posters: List<TvImagesItem> = listOf()
)