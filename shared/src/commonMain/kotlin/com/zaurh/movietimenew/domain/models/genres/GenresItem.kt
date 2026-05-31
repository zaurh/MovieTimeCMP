package com.zaurh.movietimenew.domain.models.genres

import com.zaurh.movietimenew.util.EMPTY
import com.zaurh.movietimenew.util.ZERO_LONG

data class GenresItem(
    val id: Long = ZERO_LONG,
    val name: String = EMPTY
)