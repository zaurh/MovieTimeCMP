package com.zaurh.movietimenew.data.models.movie.movie_video

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieVideoItemDTO(
    val id: String? = null,
    @SerialName("iso_3166_1")
    val languageCode: String? = null,
    @SerialName("iso_639_1")
    val countryCode: String? = null,
    val key: String? = null,
    val name: String? = null,
    val official: Boolean? = null,
    val published_at: String? = null,
    val site: String? = null,
    val size: Int? = null,
    val type: String? = null
)