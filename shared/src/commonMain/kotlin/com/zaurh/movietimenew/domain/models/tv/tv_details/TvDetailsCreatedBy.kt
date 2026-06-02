package com.zaurh.movietimenew.domain.models.tv.tv_details

import com.zaurh.movietimenew.util.EMPTY
import com.zaurh.movietimenew.util.ZERO

data class TvDetailsCreatedBy(
    val id: Int = ZERO,
    val creditId: String = EMPTY,
    val name: String = EMPTY,
    val gender: Int = ZERO,
    val profilePath: String = EMPTY
)