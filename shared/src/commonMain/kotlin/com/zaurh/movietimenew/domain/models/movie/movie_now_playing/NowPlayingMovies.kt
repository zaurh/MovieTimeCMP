package com.zaurh.movietimenew.domain.models.movie.movie_now_playing

import com.zaurh.movietimenew.util.ZERO

data class NowPlayingMovies(
    val dates: NowPlayingMoviesDates = NowPlayingMoviesDates(),
    val page: Int = ZERO,
    val results: List<NowPlayingMoviesItem> = listOf(),
    val totalPages: Int = ZERO,
    val totalResults: Int = ZERO
)