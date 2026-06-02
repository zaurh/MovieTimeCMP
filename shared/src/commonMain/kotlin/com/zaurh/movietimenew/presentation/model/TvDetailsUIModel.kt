package com.zaurh.movietimenew.presentation.model

import com.zaurh.movietimenew.domain.models.tv.tv_details.TvDetailsGenre
import com.zaurh.movietimenew.util.EMPTY
import com.zaurh.movietimenew.util.ZERO_LONG

data class TvDetailsUIModel(
    val id: Long = ZERO_LONG,
    val runtime: String = EMPTY,
    val posterPath: String = EMPTY,
    val genres: List<TvDetailsGenre> = listOf(),
    val overview: String = EMPTY,
    val firstAirDate: String = EMPTY,
    val lastAirDate: String = EMPTY,
    val title: String = EMPTY,
)
