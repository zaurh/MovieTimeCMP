package com.zaurh.movietimenew.presentation.mapper.person

import com.zaurh.movietimenew.domain.models.person.person_tv.PersonTvCastItem
import com.zaurh.movietimenew.presentation.model.MovieUIModel

fun PersonTvCastItem.toUIModel(): MovieUIModel {
    return MovieUIModel(
        id = this.id,
        title = this.name,
        posterPath = this.posterPath,
        overview = this.overview,
        releaseDate = this.firstAirDate,
        vote = this.voteAverage
    )
}