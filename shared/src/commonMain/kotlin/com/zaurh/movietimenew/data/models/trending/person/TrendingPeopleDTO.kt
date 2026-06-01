package com.zaurh.movietimenew.data.models.trending.person

import kotlinx.serialization.Serializable

@Serializable
data class TrendingPeopleDTO(
    val page: Int? = null,
    val results: List<TrendingPeopleItemDTO>? = null,
    val total_pages: Int? = null,
    val total_results: Int? = null
)