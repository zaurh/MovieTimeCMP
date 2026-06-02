package com.zaurh.movietimenew.domain.models.tv.tv_details

import com.zaurh.movietimenew.util.EMPTY
import com.zaurh.movietimenew.util.ZERO
import com.zaurh.movietimenew.util.ZERO_DOUBLE
import com.zaurh.movietimenew.util.ZERO_LONG

data class TvDetails(
    val adult: Boolean = false,
    val backdropPath: String = EMPTY,
    val createdBy: List<TvDetailsCreatedBy> = listOf(),
    val episodeRunTime: List<Int> = listOf(),
    val firstAirDate: String = EMPTY,
    val genres: List<TvDetailsGenre> = listOf(),
    val homepage: String = EMPTY,
    val id: Long = ZERO_LONG,
    val inProduction: Boolean = false,
    val languages: List<String> = listOf(),
    val lastAirDate: String = EMPTY,
    val lastEpisodeToAir: TvDetailsEpisode = TvDetailsEpisode(),
    val name: String = EMPTY,
    val nextEpisodeToAir: TvDetailsEpisode = TvDetailsEpisode(),
    val networks: List<TvDetailsNetwork> = listOf(),
    val numberOfEpisodes: Int = ZERO,
    val numberOfSeasons: Int = ZERO,
    val originCountry: List<String> = listOf(),
    val originalLanguage: String = EMPTY,
    val originalName: String = EMPTY,
    val overview: String = EMPTY,
    val popularity: Double = ZERO_DOUBLE,
    val posterPath: String = EMPTY,
    val productionCompanies: List<TvDetailsProductionCompany> = listOf(),
    val productionCountries: List<TvDetailsProductionCountry> = listOf(),
    val seasons: List<TvDetailsSeason> = listOf(),
    val spokenLanguages: List<TvDetailsSpokenLanguage> = listOf(),
    val status: String = EMPTY,
    val tagline: String = EMPTY,
    val type: String = EMPTY,
    val voteAverage: Double = ZERO_DOUBLE,
    val voteCount: Int = ZERO
)