package com.zaurh.movietimenew.data.models.tv.tv_similar
import kotlinx.serialization.Serializable

@Serializable
data class TvSimilarDTO(
    val page: Int? = null,
    val results: List<TvSimilarItemDTO>? = null,
    val total_pages: Int? = null,
    val total_results: Int? = null
)

