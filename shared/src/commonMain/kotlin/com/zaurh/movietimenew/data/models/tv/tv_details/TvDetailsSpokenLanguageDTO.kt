package com.zaurh.movietimenew.data.models.tv.tv_details

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TvDetailsSpokenLanguageDTO(
    val english_name: String? = null,
    @SerialName("iso_639_1")
    val languageCode: String? = null,
    val name: String? = null
)