package com.zaurh.movietimenew.presentation.mapper.discover

import com.zaurh.movietimenew.domain.discover.discover_movies.DiscoverMoviesItem
import com.zaurh.movietimenew.presentation.model.MovieUIModel

fun DiscoverMoviesItem.toUIModel(): MovieUIModel {
    return MovieUIModel(
        id = this.id,
        title = this.title,
        posterPath = this.posterPath,
        overview = this.overview,
        releaseDate = this.releaseDate,
        vote = this.voteAverage
    )
}