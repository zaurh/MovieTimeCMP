package com.zaurh.movietimenew.presentation.mapper.movie

import com.zaurh.movietimenew.domain.models.movie.movie_popular.PopularMoviesItem
import com.zaurh.movietimenew.presentation.model.MovieUIModel

fun PopularMoviesItem.toUIModel(): MovieUIModel {
    return MovieUIModel(
        id = this.id,
        title = this.title,
        posterPath = this.posterPath,
        overview = this.overview,
        releaseDate = this.releaseDate,
        vote = this.voteAverage
    )
}