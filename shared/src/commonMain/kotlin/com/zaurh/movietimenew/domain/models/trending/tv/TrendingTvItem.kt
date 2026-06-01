package com.zaurh.movietimenew.domain.models.trending.tv

import com.zaurh.movietimenew.util.EMPTY
import com.zaurh.movietimenew.util.ZERO
import com.zaurh.movietimenew.util.ZERO_DOUBLE
import com.zaurh.movietimenew.util.ZERO_LONG

data class TrendingTvItem(
    val adult: Boolean = false,
    val backdropPath: String = EMPTY,
    val id: Long = ZERO_LONG,
    val name: String = EMPTY,
    val originalLanguage: String = EMPTY,
    val originalName: String = EMPTY,
    val overview: String = EMPTY,
    val posterPath: String = EMPTY,
    val mediaType: String = EMPTY,
    val genreIds: List<Long> = listOf(),
    val popularity: Double = ZERO_DOUBLE,
    val firstAirDate: String = EMPTY,
    val voteAverage: Double = ZERO_DOUBLE,
    val voteCount: Int = ZERO,
    val originCountry: List<String> = listOf()
)