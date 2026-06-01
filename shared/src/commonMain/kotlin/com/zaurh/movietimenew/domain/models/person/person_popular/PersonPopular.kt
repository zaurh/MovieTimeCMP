package com.zaurh.movietimenew.domain.models.person.person_popular

import com.zaurh.movietimenew.util.ZERO

data class PersonPopular(
    val page: Int = ZERO,
    val results: List<PersonPopularItem> = listOf(),
    val totalPages: Int = ZERO,
    val totalResults: Int = ZERO
)