package com.zaurh.movietimenew.presentation.mapper.person

import com.zaurh.movietimenew.domain.models.person.person_movies.PersonMoviesCastItem
import com.zaurh.movietimenew.presentation.model.MovieUIModel

fun PersonMoviesCastItem.toUIModel(): MovieUIModel {
    return MovieUIModel(
        id = this.id,
        title = this.title,
        posterPath = this.posterPath,
        overview = this.overview,
        releaseDate = this.releaseDate,
        vote = this.voteAverage
    )
}