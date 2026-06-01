package com.zaurh.movietimenew.domain.models.person.person_tv

import com.zaurh.movietimenew.util.EMPTY
import com.zaurh.movietimenew.util.ZERO
import com.zaurh.movietimenew.util.ZERO_DOUBLE
import com.zaurh.movietimenew.util.ZERO_LONG

data class PersonTvCastItem(
    val adult: Boolean = false,
    val backdropPath: String = EMPTY,
    val genreIds: List<Int> = listOf(),
    val id: Long = ZERO_LONG,
    val originCountry: List<String> = listOf(),
    val originalLanguage: String = EMPTY,
    val originalName: String = EMPTY,
    val overview: String = EMPTY,
    val popularity: Double = ZERO_DOUBLE,
    val posterPath: String = EMPTY,
    val firstAirDate: String = EMPTY,
    val softcore: Boolean = false,
    val name: String = EMPTY,
    val voteAverage: Double = ZERO_DOUBLE,
    val voteCount: Int = ZERO,
    val character: String = EMPTY,
    val creditId: String = EMPTY,
    val episodeCount: Int = ZERO,
    val firstCreditAirDate: String = EMPTY
)