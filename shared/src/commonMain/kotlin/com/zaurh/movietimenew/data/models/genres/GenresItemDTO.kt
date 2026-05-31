package com.zaurh.movietimenew.data.models.genres

import kotlinx.serialization.Serializable

@Serializable
data class GenresItemDTO(
    val id: Long? = null,
    val name: String? = null
)