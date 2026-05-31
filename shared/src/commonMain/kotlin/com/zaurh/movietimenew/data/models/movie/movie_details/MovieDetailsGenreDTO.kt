package com.zaurh.movietimenew.data.models.movie.movie_details

import kotlinx.serialization.Serializable

@Serializable
data class MovieDetailsGenreDTO(
    val id: Long? = null,
    val name: String? = null
)