package com.zaurh.movietimenew.presentation.model

import com.zaurh.movietimenew.util.EMPTY
import com.zaurh.movietimenew.util.ZERO_LONG

data class MovieUIModel(
    val id: Long = ZERO_LONG,
    val title: String = EMPTY,
    val posterPath: String = EMPTY,
    val overview: String = EMPTY,
    val releaseDate: String = EMPTY,
    val vote: Double = 0.0
)
