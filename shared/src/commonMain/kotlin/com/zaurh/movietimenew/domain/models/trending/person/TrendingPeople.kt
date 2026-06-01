package com.zaurh.movietimenew.domain.models.trending.person

import com.zaurh.movietimenew.util.ZERO

data class TrendingPeople(
    val page: Int = ZERO,
    val results: List<TrendingPeopleItem> = listOf(),
    val totalPages: Int = ZERO,
    val totalResults: Int = ZERO
)