package com.zaurh.movietimenew.data.models.trending.person

import kotlinx.serialization.Serializable

@Serializable
data class TrendingPeopleItemDTO(
    val adult: Boolean? = null,
    val id: Long? = null,
    val name: String? = null,
    val original_name: String? = null,
    val title: String? = null,
    val original_language: String? = null,
    val original_title: String? = null,
    val overview: String? = null,
    val poster_path: String? = null,
    val backdrop_path: String? = null,
    val media_type: String? = null,
    val genre_ids: List<Long>? = null,
    val popularity: Double? = null,
    val release_date: String? = null,
    val first_air_date: String? = null,
    val video: Boolean? = null,
    val vote_average: Double? = null,
    val vote_count: Int? = null,
    val gender: Int? = null,
    val known_for_department: String? = null,
    val profile_path: String? = null,
    val known_for: List<TrendingPeopleKnownForDTO>? = null,
    val origin_country: List<String>? = null
)