package com.zaurh.movietimenew.data.models.person.person_tv
import kotlinx.serialization.Serializable

@Serializable
data class PersonTvDTO(
    val cast: List<PersonTvCastDTO>? = null,
    val crew: List<PersonTvCrewDTO>? = null,
    val id: Int? = null
)