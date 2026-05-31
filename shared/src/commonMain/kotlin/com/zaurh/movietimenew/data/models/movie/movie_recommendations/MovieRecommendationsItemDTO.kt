package com.zaurh.movietimenew.data.models.movie.movie_recommendations

import kotlinx.serialization.Serializable

@Serializable
data class MovieRecommendationsItemDTO(
    val adult: Boolean? = null,
    val backdrop_path: String? = null,
    val id: Long? = null,
    val title: String? = null,
    val original_title: String? = null,
    val overview: String? = null,
    val poster_path: String? = null,
    val media_type: String? = null,
    val original_language: String? = null,
    val genre_ids: List<Long>? = null,
    val popularity: Double? = null,
    val release_date: String? = null,
    val softcore: Boolean? = null,
    val video: Boolean? = null,
    val vote_average: Double? = null,
    val vote_count: Int? = null
)

