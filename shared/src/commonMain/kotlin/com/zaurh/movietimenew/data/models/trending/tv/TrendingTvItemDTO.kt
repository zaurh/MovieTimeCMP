package com.zaurh.movietimenew.data.models.trending.tv

import kotlinx.serialization.Serializable

@Serializable
data class TrendingTvItemDTO(
    val adult: Boolean? = null,
    val backdrop_path: String? = null,
    val id: Long? = null,
    val name: String? = null,
    val original_language: String? = null,
    val original_name: String? = null,
    val overview: String? = null,
    val poster_path: String? = null,
    val media_type: String? = null,
    val genre_ids: List<Long>? = null,
    val popularity: Double? = null,
    val first_air_date: String? = null,
    val vote_average: Double? = null,
    val vote_count: Int? = null,
    val origin_country: List<String>? = null
)