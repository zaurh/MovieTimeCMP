package com.zaurh.movietimenew.data.models.movie.movie_details

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieDetailsSpokenLanguageDTO(
    val english_name: String? = null,
    @SerialName("iso_639_1")
    val languageCode: String? = null,
    val name: String? = null
)