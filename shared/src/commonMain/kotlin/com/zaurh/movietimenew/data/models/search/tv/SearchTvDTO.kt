package com.zaurh.movietimenew.data.models.search.tv

import kotlinx.serialization.Serializable

@Serializable
data class SearchTvDTO(
    val page: Int? = null,
    val results: List<SearchTvItemDTO>? = null,
    val total_pages: Int? = null,
    val total_results: Int? = null
)