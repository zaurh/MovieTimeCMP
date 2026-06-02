package com.zaurh.movietimenew.data.mapper.tv

import com.zaurh.movietimenew.data.models.tv.tv_video.TvVideosDTO
import com.zaurh.movietimenew.data.models.tv.tv_video.TvVideosItemDTO
import com.zaurh.movietimenew.domain.models.tv.tv_video.TvVideos
import com.zaurh.movietimenew.domain.models.tv.tv_video.TvVideosItem
import com.zaurh.movietimenew.util.orFalse
import com.zaurh.movietimenew.util.orZero

fun TvVideosDTO.toDomain(): TvVideos {
    return TvVideos(
        id = this.id.orZero(), results = this.results?.map { it.toDomain() }.orEmpty()
    )
}

fun TvVideosItemDTO.toDomain(): TvVideosItem {
    return TvVideosItem(
        languageCode = this.languageCode.orEmpty(),
        countryCode = this.countryCode.orEmpty(),
        name = this.name.orEmpty(),
        key = this.key.orEmpty(),
        site = this.site.orEmpty(),
        size = this.size.orZero(),
        type = this.type.orEmpty(),
        official = this.official.orFalse(),
        publishedAt = this.published_at.orEmpty(),
        id = this.id.orEmpty()
    )
}