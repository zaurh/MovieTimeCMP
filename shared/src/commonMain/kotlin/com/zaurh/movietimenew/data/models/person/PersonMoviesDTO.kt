package com.zaurh.movietimenew.data.models.person
import kotlinx.serialization.Serializable

@Serializable
data class PersonMoviesDTO(
    val cast: List<PersonMoviesCastItemDTO>? = null,
    val id: Long? = null
)

@Serializable
data class PersonMoviesCastItemDTO(
    val adult: Boolean? = null,
    val backdrop_path: String? = null,
    val genre_ids: List<Int>? = null,
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
    val vote_count: Int? = null,
    val character: String? = null,
    val credit_id: String? = null,
    val order: Int? = null
)