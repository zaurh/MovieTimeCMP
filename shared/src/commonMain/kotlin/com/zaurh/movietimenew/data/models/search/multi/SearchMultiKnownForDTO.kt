package com.zaurh.movietimenew.data.models.search.multi

import kotlinx.serialization.Serializable

@Serializable
data class SearchMultiKnownForDTO(
    val id: Long? = null,
    val media_type: String? = null,

    val title: String? = null,
    val name: String? = null,
    val original_title: String? = null,
    val original_name: String? = null,

    val overview: String? = null,
    val poster_path: String? = null,
    val backdrop_path: String? = null,

    val genre_ids: List<Long>? = null,
    val original_language: String? = null,

    val popularity: Double? = null,
    val vote_average: Double? = null,
    val vote_count: Int? = null,

    val release_date: String? = null,
    val first_air_date: String? = null
)