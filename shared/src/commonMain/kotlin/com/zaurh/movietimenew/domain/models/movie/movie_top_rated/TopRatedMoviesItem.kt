package com.zaurh.movietimenew.domain.models.movie.movie_top_rated

import com.zaurh.movietimenew.util.EMPTY
import com.zaurh.movietimenew.util.ZERO
import com.zaurh.movietimenew.util.ZERO_DOUBLE
import com.zaurh.movietimenew.util.ZERO_LONG

data class TopRatedMoviesItem(
    val adult: Boolean = false,
    val backdropPath: String = EMPTY,
    val genreIds: List<Long> = listOf(),
    val id: Long = ZERO_LONG,
    val originalLanguage: String = EMPTY,
    val originalTitle: String = EMPTY,
    val overview: String = EMPTY,
    val popularity: Double = ZERO_DOUBLE,
    val posterPath: String = EMPTY,
    val releaseDate: String = EMPTY,
    val title: String = EMPTY,
    val video: Boolean = false,
    val voteAverage: Double = ZERO_DOUBLE,
    val voteCount: Int = ZERO
)
