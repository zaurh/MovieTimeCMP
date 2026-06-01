package com.zaurh.movietimenew.domain.models.search.multi

import com.zaurh.movietimenew.util.ZERO

data class SearchMulti(
    val page: Int = ZERO,
    val results: List<SearchMultiItem> = listOf(),
    val totalPages: Int = ZERO,
    val totalResults: Int = ZERO
)