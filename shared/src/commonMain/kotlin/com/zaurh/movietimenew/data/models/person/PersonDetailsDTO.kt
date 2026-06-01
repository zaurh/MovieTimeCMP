package com.zaurh.movietimenew.data.models.person
import kotlinx.serialization.Serializable

@Serializable
data class PersonDetailsDTO(
    val adult: Boolean? = null,
    val also_known_as: List<String>? = null,
    val biography: String? = null,
    val birthday: String? = null,
    val deathday: String? = null,
    val gender: Int? = null,
    val homepage: String? = null,
    val id: Double? = null,
    val imdb_id: String? = null,
    val known_for_department: String? = null,
    val name: String? = null,
    val place_of_birth: String? = null,
    val popularity: Double? = null,
    val profile_path: String? = null
)