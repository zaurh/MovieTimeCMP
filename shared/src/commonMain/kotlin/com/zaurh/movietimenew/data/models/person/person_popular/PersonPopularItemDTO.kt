package com.zaurh.movietimenew.data.models.person.person_popular
import kotlinx.serialization.Serializable

@Serializable
data class PersonPopularItemDTO(
    val adult: Boolean? = null,
    val gender: Int? = null,
    val id: Int? = null,
    val known_for_department: String? = null,
    val name: String? = null,
    val original_name: String? = null,
    val popularity: Double? = null,
    val profile_path: String? = null,
    val known_for: List<PersonPopularKnownForDTO>? = null
)