package com.zaurh.movieappintern2.data.mapper.movie

import com.zaurh.movietimenew.data.models.movie.movie_image.MovieImagesDTO
import com.zaurh.movietimenew.data.models.movie.movie_image.MovieImagesItemDTO
import com.zaurh.movietimenew.domain.models.movie.movie_image.MovieImages
import com.zaurh.movietimenew.domain.models.movie.movie_image.MovieImagesItem
import com.zaurh.movietimenew.util.generateImagePath
import com.zaurh.movietimenew.util.orZero

fun MovieImagesDTO.toDomain(): MovieImages {
    return MovieImages(
        backdrops = this.backdrops?.map { it.toDomain() } ?: listOf(),
        id = this.id?.toLong() ?: 0L,
        logos = this.logos?.map { it.toDomain() } ?: listOf(),
        posters = this.posters?.map { it.toDomain() } ?: listOf()
    )
}

fun MovieImagesItemDTO.toDomain(): MovieImagesItem {
    return MovieImagesItem(
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