package com.zaurh.movietimenew.data.models.movie.movie_details

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieDetailsProductionCountryDTO(
    @SerialName("iso_3166_1")
    val countryCode: String? = null,
    val name: String? = null
)