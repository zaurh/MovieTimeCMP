package com.zaurh.movietimenew.domain.models.tv.tv_details

import com.zaurh.movietimenew.util.EMPTY
import com.zaurh.movietimenew.util.ZERO

data class TvDetailsNetwork(
    val id: Int = ZERO,
    val logoPath: String = EMPTY,
    val name: String = EMPTY,
    val originCountry: String = EMPTY
)