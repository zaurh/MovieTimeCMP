package com.zaurh.movietimenew.domain.models.search.multi

import com.zaurh.movietimenew.util.EMPTY
import com.zaurh.movietimenew.util.ZERO
import com.zaurh.movietimenew.util.ZERO_DOUBLE
import com.zaurh.movietimenew.util.ZERO_LONG

data class SearchMultiKnownFor(
    val id: Long = ZERO_LONG,
    val mediaType: String = EMPTY,

    val title: String = EMPTY,
    val name: String = EMPTY,
    val originalTitle: String = EMPTY,
    val originalName: String = EMPTY,

    val overview: String = EMPTY,
    val posterPath: String = EMPTY,
    val backdropPath: String = EMPTY,

    val genreIds: List<Long> = listOf(),
    val originalLanguage: String = EMPTY,

    val popularity: Double = ZERO_DOUBLE,
    val voteAverage: Double = ZERO_DOUBLE,
    val voteCount: Int = ZERO,

    val releaseDate: String = EMPTY,
    val firstAirDate: String = EMPTY
)
