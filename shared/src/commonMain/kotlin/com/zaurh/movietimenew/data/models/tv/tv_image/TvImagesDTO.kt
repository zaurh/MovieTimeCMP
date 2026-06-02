package com.zaurh.movietimenew.data.models.tv.tv_image
import kotlinx.serialization.Serializable

@Serializable
data class TvImagesDTO(
    val backdrops: List<TvImagesItemDTO>? = null,
    val id: Int? = null,
    val logos: List<TvImagesItemDTO>? = null,
    val posters: List<TvImagesItemDTO>? = null
)