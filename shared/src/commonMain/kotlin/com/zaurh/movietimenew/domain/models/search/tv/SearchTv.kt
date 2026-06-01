package com.zaurh.movietimenew.domain.models.search.tv

import com.zaurh.movietimenew.util.ZERO

data class SearchTv(
    val page: Int = ZERO,
    val results: List<SearchTvItem> = listOf(),
    val totalPages: Int = ZERO,
    val totalResults: Int = ZERO
)