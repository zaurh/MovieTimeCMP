package com.zaurh.movietimenew.data.models.tv.tv_credits
import kotlinx.serialization.Serializable

@Serializable
data class TvCreditsCrewDTO(
    val adult: Boolean? = null,
    val gender: Int? = null,
    val id: Int? = null,
    val known_for_department: String? = null,
    val name: String? = null,
    val original_name: String? = null,
    val popularity: Double? = null,
    val profile_path: String? = null,
    val credit_id: String? = null,
    val department: String? = null,
    val job: String? = null
)