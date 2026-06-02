package com.zaurh.movietimenew.domain.models.tv.tv_details

import com.zaurh.movietimenew.util.EMPTY
import com.zaurh.movietimenew.util.ZERO
import com.zaurh.movietimenew.util.ZERO_DOUBLE

data class TvDetailsEpisode(
    val id: Int = ZERO,
    val name: String = EMPTY,
    val overview: String = EMPTY,
    val voteAverage: Double = ZERO_DOUBLE,
    val voteCount: Int = ZERO,
    val airDate: String = EMPTY,
    val episodeNumber: Int = ZERO,
    val productionCode: String = EMPTY,
    val runtime: Int = ZERO,
    val seasonNumber: Int = ZERO,
    val showId: Int = ZERO,
    val stillPath: String = EMPTY
)