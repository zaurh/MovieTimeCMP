package com.zaurh.movietimenew.domain.models.tv.tv_credits

import com.zaurh.movietimenew.util.EMPTY
import com.zaurh.movietimenew.util.ZERO
import com.zaurh.movietimenew.util.ZERO_DOUBLE

data class TvCreditsCrew(
    val adult: Boolean = false,
    val gender: Int = ZERO,
    val id: Int = ZERO,
    val knownForDepartment: String = EMPTY,
    val name: String = EMPTY,
    val originalName: String = EMPTY,
    val popularity: Double = ZERO_DOUBLE,
    val profilePath: String = EMPTY,
    val creditId: String = EMPTY,
    val department: String = EMPTY,
    val job: String = EMPTY
)