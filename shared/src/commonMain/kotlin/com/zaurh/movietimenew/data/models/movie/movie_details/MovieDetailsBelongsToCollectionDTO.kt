package com.zaurh.movietimenew.data.models.movie.movie_details

import kotlinx.serialization.Serializable

@Serializable
data class MovieDetailsBelongsToCollectionDTO(
    val id: Long? = null,
    val name: String? = null,
    val poster_path: String? = null,
    val backdrop_path: String? = null
)
