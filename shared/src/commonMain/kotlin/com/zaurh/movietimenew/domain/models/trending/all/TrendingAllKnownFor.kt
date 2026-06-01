package com.zaurh.movietimenew.domain.models.trending.all

import com.zaurh.movietimenew.util.EMPTY
import com.zaurh.movietimenew.util.ZERO
import com.zaurh.movietimenew.util.ZERO_DOUBLE
import com.zaurh.movietimenew.util.ZERO_LONG

data class TrendingAllKnownFor(
    val adult: Boolean = false,
    val backdropPath: String = EMPTY,
    val id: Long = ZERO_LONG,

    // Movie
    val title: String = EMPTY,
    val originalTitle: String = EMPTY,
    val releaseDate: String = EMPTY,
    val video: Boolean = false,

    // TV
    val name: String = EMPTY,
    val originalName: String = EMPTY,
    val firstAirDate: String = EMPTY,
    val originCountry: List<String> = listOf(),

    // Shared
    val originalLanguage: String = EMPTY,
    val overview: String = EMPTY,
    val posterPath: String = EMPTY,
    val mediaType: String = EMPTY,
    val genreIds: List<Long> = listOf(),
    val popularity: Double = ZERO_DOUBLE,
    val voteAverage: Double = ZERO_DOUBLE,
    val voteCount: Int = ZERO
)