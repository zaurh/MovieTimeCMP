package com.zaurh.movietimenew.domain.models.movie.movie_now_playing

import com.zaurh.movietimenew.util.EMPTY

data class NowPlayingMoviesDates(
    val maximum: String = EMPTY,
    val minimum: String = EMPTY
)