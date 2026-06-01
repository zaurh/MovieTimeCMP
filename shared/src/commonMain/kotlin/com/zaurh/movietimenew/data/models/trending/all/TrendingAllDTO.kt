package com.zaurh.movietimenew.data.models.trending.all

import kotlinx.serialization.Serializable

@Serializable
data class TrendingAllDTO(
    val page: Int? = null,
    val results: List<TrendingAllItemDTO>? = null,
    val total_pages: Int? = null,
    val total_results: Int? = null
)