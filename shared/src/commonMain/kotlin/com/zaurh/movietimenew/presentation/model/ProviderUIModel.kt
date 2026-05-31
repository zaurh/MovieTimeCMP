package com.zaurh.movietimenew.presentation.model

import com.zaurh.movietimenew.util.EMPTY
import com.zaurh.movietimenew.util.ZERO

data class ProviderUIModel(
    val id: Int = ZERO,
    val name: String = EMPTY,
    val logoRes: Int? = null,
    val actionUrl: String = EMPTY
)