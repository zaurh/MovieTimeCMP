package com.zaurh.movietimenew.data.models.movie.movie_upcoming

import kotlinx.serialization.Serializable

@Serializable
data class UpcomingMoviesDatesDTO(
    val maximum: String,
    val minimum: String
)