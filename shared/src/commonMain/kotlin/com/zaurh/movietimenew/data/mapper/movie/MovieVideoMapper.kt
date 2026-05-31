package com.zaurh.movieappintern2.data.mapper.movie

import com.zaurh.movietimenew.data.models.movie.movie_video.MovieVideoDTO
import com.zaurh.movietimenew.data.models.movie.movie_video.MovieVideoItemDTO
import com.zaurh.movietimenew.domain.models.movie.movie_video.MovieVideo
import com.zaurh.movietimenew.domain.models.movie.movie_video.MovieVideoItem
import com.zaurh.movietimenew.util.orFalse
import com.zaurh.movietimenew.util.orZero
import kotlin.text.orEmpty

fun MovieVideoDTO.toDomain(): MovieVideo {
    return MovieVideo(
        id = this.id.orZero(),
        results = this.results?.map { it.toDomain() }.orEmpty()
    )
}

fun MovieVideoItemDTO.toDomain(): MovieVideoItem {
    return MovieVideoItem(
        id = this.id.orEmpty(),
        languageCode = this.languageCode.orEmpty(),
        countryCode = this.countryCode.orEmpty(),
        key = this.key.orEmpty(),
        name = this.name.orEmpty(),
        official = this.official.orFalse(),
        publishedAt = this.published_at.orEmpty(),
        site = this.site.orEmpty(),
        size = this.size.orZero(),
        type = this.type.orEmpty()
    )
}