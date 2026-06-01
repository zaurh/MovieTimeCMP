package com.zaurh.movietimenew.domain.models.trending.all

import com.zaurh.movietimenew.util.ZERO

data class TrendingAll(
    val page: Int = ZERO,
    val results: List<TrendingAllItem> = listOf(),
    val totalPages: Int = ZERO,
    val totalResults: Int = ZERO
)