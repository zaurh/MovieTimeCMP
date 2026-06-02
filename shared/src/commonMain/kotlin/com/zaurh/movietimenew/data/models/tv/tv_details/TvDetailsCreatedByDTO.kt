package com.zaurh.movietimenew.data.models.tv.tv_details
import kotlinx.serialization.Serializable

@Serializable
data class TvDetailsCreatedByDTO(
    val id: Int? = null,
    val credit_id: String? = null,
    val name: String? = null,
    val gender: Int? = null,
    val profile_path: String? = null
)