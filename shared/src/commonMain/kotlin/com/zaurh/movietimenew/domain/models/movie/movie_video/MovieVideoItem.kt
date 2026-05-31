package com.zaurh.movietimenew.domain.models.movie.movie_video

import com.zaurh.movietimenew.util.EMPTY
import com.zaurh.movietimenew.util.ZERO

data class MovieVideoItem(
    val id: String = EMPTY,
    val languageCode: String = EMPTY,
    val countryCode: String = EMPTY,
    val key: String = EMPTY,
    val name: String = EMPTY,
    val official: Boolean = false,
    val publishedAt: String = EMPTY,
    val site: String = EMPTY,
    val size: Int = ZERO,
    val type: String = EMPTY
)