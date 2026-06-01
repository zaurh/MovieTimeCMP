package com.zaurh.movietimenew.domain.models.person.person_movies

import com.zaurh.movietimenew.util.EMPTY
import com.zaurh.movietimenew.util.ZERO
import com.zaurh.movietimenew.util.ZERO_DOUBLE
import com.zaurh.movietimenew.util.ZERO_LONG

data class PersonMoviesCastItem(
    val adult: Boolean = false,
    val backdropPath: String = EMPTY,
    val genreIds: List<Int> = listOf(),
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
    val voteCount: Int = ZERO,
    val character: String = EMPTY,
    val creditId: String = EMPTY,
    val order: Int = ZERO
)