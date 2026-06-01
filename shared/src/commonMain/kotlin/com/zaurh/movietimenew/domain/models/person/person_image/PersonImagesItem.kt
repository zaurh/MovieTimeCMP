package com.zaurh.movietimenew.domain.models.person.person_image

import com.zaurh.movietimenew.util.EMPTY
import com.zaurh.movietimenew.util.ZERO
import com.zaurh.movietimenew.util.ZERO_DOUBLE

data class PersonImagesItem(
    val aspectRatio: Double = ZERO_DOUBLE,
    val height: Int = ZERO,
    val languageCode: String = EMPTY,
    val filePath: String = EMPTY,
    val voteAverage: Double = ZERO_DOUBLE,
    val voteCount: Int = ZERO,
    val width: Int = ZERO
)