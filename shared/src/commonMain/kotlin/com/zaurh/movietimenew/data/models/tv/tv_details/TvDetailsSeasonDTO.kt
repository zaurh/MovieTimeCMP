package com.zaurh.movietimenew.data.models.tv.tv_details
import kotlinx.serialization.Serializable

@Serializable
data class TvDetailsSeasonDTO(
    val air_date: String? = null,
    val episode_count: Int? = null,
    val id: Int? = null,
    val name: String? = null,
    val overview: String? = null,
    val poster_path: String? = null,
    val season_number: Int? = null,
    val vote_average: Double? = null
)