package com.zaurh.movietimenew.domain.models.person.person_details

import com.zaurh.movietimenew.util.EMPTY
import com.zaurh.movietimenew.util.ZERO
import com.zaurh.movietimenew.util.ZERO_DOUBLE

data class PersonDetails(
    val adult: Boolean = false,
    val alsoKnownAs: List<String> = listOf(),
    val biography: String = EMPTY,
    val birthday: String = EMPTY,
    val deathday: String = EMPTY,
    val gender: Int = ZERO,
    val homepage: String = EMPTY,
    val id: Double = ZERO_DOUBLE,
    val imdbId: String = EMPTY,
    val knownForDepartment: String = EMPTY,
    val name: String = EMPTY,
    val placeOfBirth: String = EMPTY,
    val popularity: Double = ZERO_DOUBLE,
    val profilePath: String = EMPTY
)