package com.zaurh.movietimenew.domain.models.tv.tv_similar

import com.zaurh.movietimenew.util.ZERO

data class TvSimilar(
    val page: Int = ZERO,
    val results: List<TvSimilarItem> = listOf(),
    val totalPages: Int = ZERO,
    val totalResults: Int = ZERO
)

