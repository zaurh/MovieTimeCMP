package com.zaurh.movietimenew.data.mapper.tv

import com.zaurh.movietimenew.data.models.tv.tv_watch_providers.TvWatchProvidersCountryItemDTO
import com.zaurh.movietimenew.data.models.tv.tv_watch_providers.TvWatchProvidersDTO
import com.zaurh.movietimenew.data.models.tv.tv_watch_providers.TvWatchProvidersProviderDTO
import com.zaurh.movietimenew.domain.models.tv.tv_watch_providers.TvWatchProviders
import com.zaurh.movietimenew.domain.models.tv.tv_watch_providers.TvWatchProvidersCountryItem
import com.zaurh.movietimenew.domain.models.tv.tv_watch_providers.TvWatchProvidersProvider
import com.zaurh.movietimenew.util.generateImagePath
import com.zaurh.movietimenew.util.orZero

fun TvWatchProvidersDTO.toDomain(): TvWatchProviders {
    return TvWatchProviders(
        id = this.id.orZero(),
        results = this.results?.mapValues { it.value.toDomain() }.orEmpty()
    )
}

fun TvWatchProvidersCountryItemDTO.toDomain(): TvWatchProvidersCountryItem {
    return TvWatchProvidersCountryItem(
        link = this.link.orEmpty(),
        flatrate = this.flatrate.orEmpty().map { it.toDomain() },
        rent = this.rent.orEmpty().map { it.toDomain() },
        buy = this.buy.orEmpty().map { it.toDomain() }
    )
}

fun TvWatchProvidersProviderDTO.toDomain(): TvWatchProvidersProvider {
    return TvWatchProvidersProvider(
        logoPath = generateImagePath(this.logo_path),
        providerId = this.provider_id.orZero(),
        providerName = this.provider_name.orEmpty(),
        displayPriority = this.display_priority.orZero()
    )
}