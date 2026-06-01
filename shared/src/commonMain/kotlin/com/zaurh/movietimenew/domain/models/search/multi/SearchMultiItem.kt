package com.zaurh.movietimenew.domain.models.search.multi

import com.zaurh.movietimenew.util.EMPTY
import com.zaurh.movietimenew.util.ZERO
import com.zaurh.movietimenew.util.ZERO_DOUBLE
import com.zaurh.movietimenew.util.ZERO_LONG

data class SearchMultiItem(
    val id: Long = ZERO_LONG,
    val mediaType: String = EMPTY,

    // Common
    val popularity: Double = ZERO_DOUBLE,
    val adult: Boolean = false,

    // Movie / TV
    val title: String = EMPTY,
    val name: String = EMPTY,
    val originalTitle: String = EMPTY,
    val originalName: String = EMPTY,
    val overview: String = EMPTY,
    val posterPath: String = EMPTY,
    val backdropPath: String = EMPTY,
    val genreIds: List<Long> = listOf(),
    val originalLanguage: String = EMPTY,
    val voteAverage: Double = ZERO_DOUBLE,
    val voteCount: Int = ZERO,

    // Movie only
    val releaseDate: String = EMPTY,
    val video: Boolean = false,

    // TV only
    val firstAirDate: String = EMPTY,
    val originCountry: List<String> = listOf(),

    // Person only
    val gender: Int = ZERO,
    val knownForDepartment: String = EMPTY,
    val profilePath: String = EMPTY,
    val knownFor: List<SearchMultiKnownFor> = listOf()
)