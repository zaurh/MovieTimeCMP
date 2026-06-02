package com.zaurh.movietimenew.domain.models.tv.tv_credits

import com.zaurh.movietimenew.util.ZERO

data class TvCredits(
    val cast: List<TvCreditsCast> = listOf(),
    val crew: List<TvCreditsCrew> = listOf(),
    val id: Int = ZERO
)