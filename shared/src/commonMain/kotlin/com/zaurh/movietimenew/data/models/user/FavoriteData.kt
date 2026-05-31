package com.zaurh.movietimenew.data.models.user

import com.zaurh.movietimenew.util.EMPTY
import com.zaurh.movietimenew.util.ZERO_LONG

data class FavoriteData(
    val movieId: Long = ZERO_LONG,
    val poster: String = EMPTY
)