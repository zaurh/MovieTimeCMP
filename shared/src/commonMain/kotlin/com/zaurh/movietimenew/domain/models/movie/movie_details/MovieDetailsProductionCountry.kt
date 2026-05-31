package com.zaurh.movietimenew.domain.models.movie.movie_details

import com.zaurh.movietimenew.util.EMPTY

data class MovieDetailsProductionCountry(
    val countryCode: String = EMPTY,
    val name: String = EMPTY
)