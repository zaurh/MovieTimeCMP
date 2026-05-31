package com.zaurh.movietimenew.domain.models.movie.movie_details

import com.zaurh.movietimenew.util.EMPTY
import com.zaurh.movietimenew.util.ZERO_LONG

data class MovieDetailsGenre(
    val id: Long = ZERO_LONG,
    val name: String = EMPTY
)