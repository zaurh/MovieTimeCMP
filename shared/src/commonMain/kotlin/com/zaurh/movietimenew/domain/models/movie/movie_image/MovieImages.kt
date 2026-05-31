package com.zaurh.movietimenew.domain.models.movie.movie_image

import com.zaurh.movietimenew.util.ZERO_LONG

data class MovieImages(
    val backdrops: List<MovieImagesItem> = listOf(),
    val id: Long = ZERO_LONG,
    val logos: List<MovieImagesItem> = listOf(),
    val posters: List<MovieImagesItem> = listOf()
)