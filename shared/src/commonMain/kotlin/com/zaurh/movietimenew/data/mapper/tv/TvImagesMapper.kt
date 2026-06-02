package com.zaurh.movietimenew.data.mapper.tv

import com.zaurh.movietimenew.data.models.tv.tv_image.TvImagesDTO
import com.zaurh.movietimenew.data.models.tv.tv_image.TvImagesItemDTO
import com.zaurh.movietimenew.domain.models.tv.tv_image.TvImages
import com.zaurh.movietimenew.domain.models.tv.tv_image.TvImagesItem
import com.zaurh.movietimenew.util.generateImagePath
import com.zaurh.movietimenew.util.orZero

fun TvImagesDTO.toDomain(): TvImages {
    return TvImages(
        backdrops = this.backdrops?.map { it.toDomain() } ?: listOf(),
        id = this.id?.toLong() ?: 0L,
        logos = this.logos?.map { it.toDomain() } ?: listOf(),
        posters = this.posters?.map { it.toDomain() } ?: listOf()
    )
}

fun TvImagesItemDTO.toDomain(): TvImagesItem {
    return TvImagesItem(
        aspectRatio = this.aspect_ratio.orZero(),
        height = this.height.orZero(),
        countryCode = this.iso_3166_1.orEmpty(),
        languageCode = this.iso_639_1.orEmpty(),
        filePath = generateImagePath(this.file_path),
        voteAverage = this.vote_average.orZero(),
        voteCount = this.vote_count.orZero(),
        width = this.width.orZero()
    )
}