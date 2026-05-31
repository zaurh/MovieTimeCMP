package com.zaurh.movietimenew.data.models.movie.movie_credits

import kotlinx.serialization.Serializable

@Serializable
data class MovieCreditsDTO(
    val id: Int? = null,
    val cast: List<MovieCreditsCastDTO>? = null
)