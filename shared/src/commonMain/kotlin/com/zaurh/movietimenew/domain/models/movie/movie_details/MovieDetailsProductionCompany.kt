package com.zaurh.movietimenew.domain.models.movie.movie_details

import com.zaurh.movietimenew.util.EMPTY
import com.zaurh.movietimenew.util.ZERO_LONG

data class MovieDetailsProductionCompany(
    val id: Long = ZERO_LONG,
    val logoPath: String = EMPTY,
    val name: String = EMPTY,
    val originCountry: String = EMPTY
)