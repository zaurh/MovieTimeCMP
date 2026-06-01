package com.zaurh.movietimenew.domain.models.trending.person

import com.zaurh.movietimenew.util.EMPTY
import com.zaurh.movietimenew.util.ZERO
import com.zaurh.movietimenew.util.ZERO_DOUBLE

data class TrendingPeopleKnownFor(
    val adult: Boolean = false,
    val backdropPath: String = EMPTY,
    val id: Int = ZERO,
    val title: String = EMPTY,
    val name: String = EMPTY,
    val originalLanguage: String = EMPTY,
    val originalTitle: String = EMPTY,
    val originalName: String = EMPTY,
    val overview: String = EMPTY,
    val posterPath: String = EMPTY,
    val mediaType: String = EMPTY,
    val genreIds: List<Int> = listOf(),
    val popularity: Double = ZERO_DOUBLE,
    val releaseDate: String = EMPTY,
    val firstAirDate: String = EMPTY,
    val video: Boolean = false,
    val voteAverage: Double = ZERO_DOUBLE,
    val voteCount: Int = ZERO,
    val originCountry: List<String> = listOf()
)