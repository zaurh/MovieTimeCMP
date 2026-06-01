package com.zaurh.movietimenew.domain.models.person.person_popular

import com.zaurh.movietimenew.util.EMPTY
import com.zaurh.movietimenew.util.ZERO
import com.zaurh.movietimenew.util.ZERO_DOUBLE
import com.zaurh.movietimenew.util.ZERO_LONG

data class PersonPopularItem(
    val adult: Boolean = false,
    val gender: Int = ZERO,
    val id: Long = ZERO_LONG,
    val knownForDepartment: String = EMPTY,
    val name: String = EMPTY,
    val originalName: String = EMPTY,
    val popularity: Double = ZERO_DOUBLE,
    val profilePath: String = EMPTY,
    val knownFor: List<PersonPopularKnownFor> = listOf()
)