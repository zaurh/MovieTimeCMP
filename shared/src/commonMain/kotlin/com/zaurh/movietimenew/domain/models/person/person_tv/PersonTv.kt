package com.zaurh.movietimenew.domain.models.person.person_tv

import com.zaurh.movietimenew.util.ZERO

data class PersonTv(
    val cast: List<PersonTvCastItem> = listOf(),
    val crew: List<PersonTvCrewItem> = listOf(),
    val id: Int = ZERO
)