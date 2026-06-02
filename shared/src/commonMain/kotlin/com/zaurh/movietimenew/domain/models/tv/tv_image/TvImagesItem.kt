package com.zaurh.movietimenew.domain.models.tv.tv_image

import com.zaurh.movietimenew.util.EMPTY
import com.zaurh.movietimenew.util.ZERO
import com.zaurh.movietimenew.util.ZERO_DOUBLE

data class TvImagesItem(
    val aspectRatio: Double = ZERO_DOUBLE,
    val height: Int = ZERO,
    val countryCode: String = EMPTY,
    val languageCode: String = EMPTY,
    val filePath: String = EMPTY,
    val voteAverage: Double = ZERO_DOUBLE,
    val voteCount: Int = ZERO,
    val width: Int = ZERO
)