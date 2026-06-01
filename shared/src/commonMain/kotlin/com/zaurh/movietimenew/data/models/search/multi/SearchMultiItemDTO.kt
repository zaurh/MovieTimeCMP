package com.zaurh.movietimenew.data.models.search.multi

import kotlinx.serialization.Serializable

@Serializable
data class SearchMultiItemDTO(
    val id: Long? = null,
    val media_type: String? = null,

    // Common
    val popularity: Double? = null,
    val adult: Boolean? = null,

    // Movie / TV
    val title: String? = null,
    val name: String? = null,
    val original_title: String? = null,
    val original_name: String? = null,
    val overview: String? = null,
    val poster_path: String? = null,
    val backdrop_path: String? = null,
    val genre_ids: List<Long>? = null,
    val original_language: String? = null,
    val vote_average: Double? = null,
    val vote_count: Int? = null,

    // Movie only
    val release_date: String? = null,
    val video: Boolean? = null,

    // TV only
    val first_air_date: String? = null,
    val origin_country: List<String>? = null,

    // Person only
    val gender: Int? = null,
    val known_for_department: String? = null,
    val profile_path: String? = null,
    val known_for: List<SearchMultiKnownForDTO>? = null
)