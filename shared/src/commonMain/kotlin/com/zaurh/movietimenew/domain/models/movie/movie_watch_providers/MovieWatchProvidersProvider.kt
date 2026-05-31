package com.zaurh.movietimenew.domain.models.movie.movie_watch_providers

import com.zaurh.movietimenew.util.EMPTY
import com.zaurh.movietimenew.util.ZERO

data class MovieWatchProvidersProvider(
    val logoPath: String = EMPTY,
    val providerId: Int = ZERO,
    val providerName: String = EMPTY,
    val displayPriority: Int = ZERO
)