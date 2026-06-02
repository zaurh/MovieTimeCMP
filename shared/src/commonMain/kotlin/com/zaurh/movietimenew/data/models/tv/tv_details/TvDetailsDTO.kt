package com.zaurh.movietimenew.data.models.tv.tv_details

import kotlinx.serialization.Serializable

@Serializable
data class TvDetailsDTO(
    val adult: Boolean? = null,
    val backdrop_path: String? = null,
    val created_by: List<TvDetailsCreatedByDTO>? = null,
    val episode_run_time: List<Int>? = null,
    val first_air_date: String? = null,
    val genres: List<TvDetailsGenreDTO>? = null,
    val homepage: String? = null,
    val id: Long? = null,
    val in_production: Boolean? = null,
    val languages: List<String>? = null,
    val last_air_date: String? = null,
    val last_episode_to_air: TvDetailsEpisodeDTO? = null,
    val name: String? = null,
    val next_episode_to_air: TvDetailsEpisodeDTO? = null,
    val networks: List<TvDetailsNetworkDTO>? = null,
    val number_of_episodes: Int? = null,
    val number_of_seasons: Int? = null,
    val origin_country: List<String>? = null,
    val original_language: String? = null,
    val original_name: String? = null,
    val overview: String? = null,
    val popularity: Double? = null,
    val poster_path: String? = null,
    val production_companies: List<TvDetailsProductionCompanyDTO>? = null,
    val production_countries: List<TvDetailsProductionCountryDTO>? = null,
    val seasons: List<TvDetailsSeasonDTO>? = null,
    val spoken_languages: List<TvDetailsSpokenLanguageDTO>? = null,
    val status: String? = null,
    val tagline: String? = null,
    val type: String? = null,
    val vote_average: Double? = null,
    val vote_count: Int? = null
)