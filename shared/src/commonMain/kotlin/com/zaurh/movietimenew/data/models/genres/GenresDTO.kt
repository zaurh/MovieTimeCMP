package com.zaurh.movietimenew.data.models.genres

import kotlinx.serialization.Serializable

@Serializable
data class GenresDTO(
    val genres: List<GenresItemDTO>? = null
)