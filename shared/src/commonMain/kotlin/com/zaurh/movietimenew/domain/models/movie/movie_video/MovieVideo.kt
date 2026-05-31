package com.zaurh.movietimenew.domain.models.movie.movie_video

import com.zaurh.movietimenew.util.ZERO_LONG

data class MovieVideo(
    val id: Long = ZERO_LONG,
    val results: List<MovieVideoItem> = listOf()
)