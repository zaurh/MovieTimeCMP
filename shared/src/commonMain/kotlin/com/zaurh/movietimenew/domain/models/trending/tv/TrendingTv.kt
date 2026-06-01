package com.zaurh.movietimenew.domain.models.trending.tv

import com.zaurh.movietimenew.util.ZERO

data class TrendingTv(
    val page: Int = ZERO,
    val results: List<TrendingTvItem> = listOf(),
    val totalPages: Int = ZERO,
    val totalResults: Int = ZERO
)