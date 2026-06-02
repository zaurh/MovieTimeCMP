package com.zaurh.movietimenew.domain.models.tv.tv_details

import com.zaurh.movietimenew.util.EMPTY
import com.zaurh.movietimenew.util.ZERO
import com.zaurh.movietimenew.util.ZERO_DOUBLE

data class TvDetailsSeason(
    val airDate: String = EMPTY,
    val episodeCount: Int = ZERO,
    val id: Int = ZERO,
    val name: String = EMPTY,
    val overview: String = EMPTY,
    val posterPath: String = EMPTY,
    val seasonNumber: Int = ZERO,
    val voteAverage: Double = ZERO_DOUBLE
)