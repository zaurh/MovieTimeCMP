package com.zaurh.movietimenew.domain.models.trending.movie

import com.zaurh.movietimenew.util.EMPTY
import com.zaurh.movietimenew.util.ZERO
import com.zaurh.movietimenew.util.ZERO_DOUBLE
import com.zaurh.movietimenew.util.ZERO_LONG

data class TrendingMoviesItem(
    val adult: Boolean = false,
    val backdropPath: String = EMPTY,
    val id: Long = ZERO_LONG,
    val title: String = EMPTY,
    val originalLanguage: String = EMPTY,
    val originalTitle: String = EMPTY,
    val overview: String = EMPTY,
    val posterPath: String = EMPTY,
    val mediaType: String = EMPTY,
    val genreIds: List<Long> = listOf(),
    val popularity: Double = ZERO_DOUBLE,
    val releaseDate: String = EMPTY,
    val video: Boolean = false,
    val voteAverage: Double = ZERO_DOUBLE,
    val voteCount: Int = ZERO
)