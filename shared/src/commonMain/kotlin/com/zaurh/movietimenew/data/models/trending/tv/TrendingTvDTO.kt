package com.zaurh.movietimenew.data.models.trending.tv

import kotlinx.serialization.Serializable

@Serializable
data class TrendingTvDTO(
    val page: Int? = null,
    val results: List<TrendingTvItemDTO>? = null,
    val total_pages: Int? = null,
    val total_results: Int? = null
)