package com.zaurh.movietimenew.data.models.movie.movie_image

import kotlinx.serialization.Serializable

@Serializable
data class MovieImagesDTO(
    val backdrops: List<MovieImagesItemDTO>? = null,
    val id: Int? = null,
    val logos: List<MovieImagesItemDTO>? = null,
    val posters: List<MovieImagesItemDTO>? = null
)