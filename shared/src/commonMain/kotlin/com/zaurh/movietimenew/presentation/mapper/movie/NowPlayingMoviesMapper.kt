package com.zaurh.movietimenew.presentation.mapper.movie

import com.zaurh.movietimenew.domain.models.movie.movie_now_playing.NowPlayingMoviesItem
import com.zaurh.movietimenew.presentation.model.MovieUIModel

fun NowPlayingMoviesItem.toUIModel(): MovieUIModel {
    return MovieUIModel(
        id = this.id,
        title = this.title,
        posterPath = this.posterPath,
        overview = this.overview,
        releaseDate = this.releaseDate,
        vote = this.voteAverage
    )
}