package com.zaurh.movietimenew.data.models.tv.tv_details

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TvDetailsProductionCountryDTO(
    @SerialName("iso_3166_1")
    val countryCode: String? = null,
    val name: String? = null
)