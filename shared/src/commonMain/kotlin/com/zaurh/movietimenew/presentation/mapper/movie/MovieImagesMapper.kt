package com.zaurh.movietimenew.presentation.mapper.movie

import com.zaurh.movietimenew.domain.models.movie.movie_image.MovieImagesItem
import com.zaurh.movietimenew.presentation.model.WallpaperUIModel

fun MovieImagesItem.toUIModel(): WallpaperUIModel {
    return WallpaperUIModel(
        filePath = this.filePath,
        voteAverage = this.voteAverage,
        voteCount = this.voteCount
    )
}