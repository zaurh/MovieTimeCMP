package com.zaurh.movietimenew.data.models.movie.movie_now_playing

import kotlinx.serialization.Serializable

@Serializable
data class NowPlayingMoviesDTO(
    val dates: NowPlayingMoviesDatesDTO? = null,
    val page: Int? = null,
    val results: List<NowPlayingMoviesItemDTO>? = null,
    val total_pages: Int? = null,
    val total_results: Int? = null
)