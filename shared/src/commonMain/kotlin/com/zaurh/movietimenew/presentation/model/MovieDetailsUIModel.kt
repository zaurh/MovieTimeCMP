package com.zaurh.movietimenew.presentation.model

import com.zaurh.movietimenew.domain.models.movie.movie_details.MovieDetailsGenre
import com.zaurh.movietimenew.util.EMPTY
import com.zaurh.movietimenew.util.ZERO_LONG

data class MovieDetailsUIModel(
    val id: Long = ZERO_LONG,
    val runtime: String = EMPTY,
    val posterPath: String = EMPTY,
    val overview: String = EMPTY,
    val genres: List<MovieDetailsGenre> = listOf(),
    val releaseDate: String = EMPTY,
    val title: String = EMPTY,
)
