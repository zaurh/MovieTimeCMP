package com.zaurh.movietimenew.data.models.movie.movie_now_playing

import kotlinx.serialization.Serializable

@Serializable
data class NowPlayingMoviesDatesDTO(
    val maximum: String? = null,
    val minimum: String? = null
)