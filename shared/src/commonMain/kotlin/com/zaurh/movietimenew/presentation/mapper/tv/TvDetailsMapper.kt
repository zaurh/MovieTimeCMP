package com.zaurh.movietimenew.presentation.mapper.tv

import com.zaurh.movietimenew.domain.models.tv.tv_details.TvDetails
import com.zaurh.movietimenew.presentation.model.TvDetailsUIModel

fun TvDetails.toUIModel(): TvDetailsUIModel {
    return TvDetailsUIModel(
        id = this.id,
        posterPath = this.posterPath,
        overview = this.overview,
        firstAirDate = this.firstAirDate,
        lastAirDate = this.lastAirDate,
        title = this.name,
        genres = this.genres
    )
}