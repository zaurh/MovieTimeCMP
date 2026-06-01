package com.zaurh.movietimenew.domain.models.person.person_popular

import com.zaurh.movietimenew.util.EMPTY
import com.zaurh.movietimenew.util.ZERO
import com.zaurh.movietimenew.util.ZERO_DOUBLE
import com.zaurh.movietimenew.util.ZERO_LONG

data class PersonPopularKnownFor(
    val adult: Boolean = false,
    val backdropPath: String = EMPTY,
    val id: Long = ZERO_LONG,
    val title: String = EMPTY,
    val originalTitle: String = EMPTY,
    val overview: String = EMPTY,
    val posterPath: String = EMPTY,
    val mediaType: String = EMPTY,
    val originalLanguage: String = EMPTY,
    val genreIds: List<Int> = listOf(),
    val popularity: Double = ZERO_DOUBLE,
    val releaseDate: String = EMPTY,
    val softcore: Boolean = false,
    val video: Boolean = false,
    val voteAverage: Double = ZERO_DOUBLE,
    val voteCount: Int = ZERO
)