package com.zaurh.movietimenew.data.models.search.person

import kotlinx.serialization.Serializable

@Serializable
data class SearchPersonDTO(
    val page: Int? = null,
    val results: List<SearchPersonItemDTO>? = null,
    val total_pages: Int? = null,
    val total_results: Int? = null
)