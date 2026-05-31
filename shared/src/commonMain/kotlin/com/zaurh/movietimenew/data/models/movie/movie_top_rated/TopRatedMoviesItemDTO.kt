package com.zaurh.movietimenew.data.models.movie.movie_top_rated

import kotlinx.serialization.Serializable

@Serializable
data class TopRatedMoviesItemDTO(
    val adult: Boolean? = null,
    val backdrop_path: String? = null,
    val genre_ids: List<Long>? = null,
    val id: Long? = null,
    val original_language: String? = null,
    val original_title: String? = null,
    val overview: String? = null,
    val popularity: Double? = null,
    val poster_path: String? = null,
    val release_date: String? = null,
    val title: String? = null,
    val video: Boolean? = null,
    val vote_average: Double? = null,
    val vote_count: Int? = null
)