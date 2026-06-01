package com.zaurh.movietimenew.data.models.search.multi

import kotlinx.serialization.Serializable

@Serializable
data class SearchMultiDTO(
    val page: Int? = null,
    val results: List<SearchMultiItemDTO>? = null,
    val total_pages: Int? = null,
    val total_results: Int? = null
)