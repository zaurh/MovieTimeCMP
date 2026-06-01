package com.zaurh.movietimenew.domain.models.search.person

import com.zaurh.movietimenew.util.ZERO

data class SearchPerson(
    val page: Int = ZERO,
    val results: List<SearchPersonItem> = listOf(),
    val totalPages: Int = ZERO,
    val totalResults: Int = ZERO
)