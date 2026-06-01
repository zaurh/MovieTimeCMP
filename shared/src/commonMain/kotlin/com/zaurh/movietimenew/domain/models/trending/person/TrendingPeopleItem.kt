package com.zaurh.movietimenew.domain.models.trending.person

import com.zaurh.movietimenew.util.EMPTY
import com.zaurh.movietimenew.util.ZERO
import com.zaurh.movietimenew.util.ZERO_DOUBLE
import com.zaurh.movietimenew.util.ZERO_LONG

data class TrendingPeopleItem(
    val adult: Boolean = false,
    val id: Long = ZERO_LONG,
    val name: String = EMPTY,
    val originalName: String = EMPTY,
    val title: String = EMPTY,
    val originalLanguage: String = EMPTY,
    val originalTitle: String = EMPTY,
    val overview: String = EMPTY,
    val posterPath: String = EMPTY,
    val backdropPath: String = EMPTY,
    val mediaType: String = EMPTY,
    val genreIds: List<Long> = listOf(),
    val popularity: Double = ZERO_DOUBLE,
    val releaseDate: String = EMPTY,
    val firstAirDate: String = EMPTY,
    val video: Boolean = false,
    val voteAverage: Double = ZERO_DOUBLE,
    val voteCount: Int = ZERO,
    val gender: Int = ZERO,
    val knownForDepartment: String = EMPTY,
    val profilePath: String = EMPTY,
    val knownFor: List<TrendingPeopleKnownFor> = listOf(),
    val originCountry: List<String> = listOf()
)