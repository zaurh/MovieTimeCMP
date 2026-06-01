package com.zaurh.movietimenew.data.models.search.person

import kotlinx.serialization.Serializable

@Serializable
data class SearchPersonItemDTO(
    val id: Long? = null,
    val name: String? = null,
    val original_name: String? = null,
    val gender: Int? = null,
    val known_for_department: String? = null,
    val popularity: Double? = null,
    val profile_path: String? = null,
    val adult: Boolean? = null,
    val known_for: List<SearchPersonKnownForDTO>? = null
)