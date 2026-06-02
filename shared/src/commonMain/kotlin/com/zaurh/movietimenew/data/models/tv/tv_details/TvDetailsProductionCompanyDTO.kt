package com.zaurh.movietimenew.data.models.tv.tv_details
import kotlinx.serialization.Serializable

@Serializable
data class TvDetailsProductionCompanyDTO(
    val id: Int? = null,
    val logo_path: String? = null,
    val name: String? = null,
    val origin_country: String? = null
)