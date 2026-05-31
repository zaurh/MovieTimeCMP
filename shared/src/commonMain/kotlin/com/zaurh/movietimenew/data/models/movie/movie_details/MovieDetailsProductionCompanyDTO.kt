package com.zaurh.movietimenew.data.models.movie.movie_details

import kotlinx.serialization.Serializable

@Serializable
data class MovieDetailsProductionCompanyDTO(
    val id: Long? = null,
    val logo_path: String? = null,
    val name: String? = null,
    val origin_country: String? = null
)