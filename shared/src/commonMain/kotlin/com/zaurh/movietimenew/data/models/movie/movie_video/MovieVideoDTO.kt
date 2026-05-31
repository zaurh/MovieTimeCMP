package com.zaurh.movietimenew.data.models.movie.movie_video

import kotlinx.serialization.Serializable

@Serializable
data class MovieVideoDTO(
    val id: Long? = null,
    val results: List<MovieVideoItemDTO>? = null
)