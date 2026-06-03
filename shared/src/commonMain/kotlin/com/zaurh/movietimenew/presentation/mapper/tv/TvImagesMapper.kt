package com.zaurh.movietimenew.presentation.mapper.tv

import com.zaurh.movietimenew.domain.models.tv.tv_image.TvImagesItem
import com.zaurh.movietimenew.presentation.model.WallpaperUIModel

fun TvImagesItem.toUIModel(): WallpaperUIModel {
    return WallpaperUIModel(
        filePath = this.filePath,
        voteAverage = this.voteAverage,
        voteCount = this.voteCount
    )
}