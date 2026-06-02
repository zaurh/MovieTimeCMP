package com.zaurh.movietimenew.data.models.tv.tv_credits

import kotlinx.serialization.Serializable

@Serializable
data class TvCreditsDTO(
    val cast: List<TvCreditsCastDTO>? = null,
    val crew: List<TvCreditsCrewDTO>? = null,
    val id: Int? = null
)