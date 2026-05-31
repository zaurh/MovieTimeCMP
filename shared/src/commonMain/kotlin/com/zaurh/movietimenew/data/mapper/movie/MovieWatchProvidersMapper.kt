package com.zaurh.movieappintern2.data.mapper.movie

import com.zaurh.movietimenew.data.models.movie.movie_watch_providers.MovieWatchProvidersCountryItemDTO
import com.zaurh.movietimenew.data.models.movie.movie_watch_providers.MovieWatchProvidersDTO
import com.zaurh.movietimenew.data.models.movie.movie_watch_providers.MovieWatchProvidersProviderDTO
import com.zaurh.movietimenew.domain.models.movie.movie_watch_providers.MovieWatchProviders
import com.zaurh.movietimenew.domain.models.movie.movie_watch_providers.MovieWatchProvidersCountryItem
import com.zaurh.movietimenew.domain.models.movie.movie_watch_providers.MovieWatchProvidersProvider
import com.zaurh.movietimenew.util.generateImagePath
import com.zaurh.movietimenew.util.orZero

fun MovieWatchProvidersDTO.toDomain(): MovieWatchProviders {
    return MovieWatchProviders(
        id = this.id.orZero(),
        results = this.results?.mapValues { it.value.toDomain() }.orEmpty()
    )
}

fun MovieWatchProvidersCountryItemDTO.toDomain(): MovieWatchProvidersCountryItem {
    return MovieWatchProvidersCountryItem(
        link = this.link.orEmpty(),
        flatrate = this.flatrate.orEmpty().map { it.toDomain() },
        rent = this.rent.orEmpty().map { it.toDomain() },
        buy = this.buy.orEmpty().map { it.toDomain() }
    )
}

fun MovieWatchProvidersProviderDTO.toDomain(): MovieWatchProvidersProvider {
    return MovieWatchProvidersProvider(
        logoPath = generateImagePath(this.logo_path),
        providerId = this.provider_id.orZero(),
        providerName = this.provider_name.orEmpty(),
        displayPriority = this.display_priority.orZero()
    )
}