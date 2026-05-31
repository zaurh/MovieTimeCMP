package com.zaurh.movietimenew.presentation.mapper.movie

import com.zaurh.movietimenew.domain.models.movie.movie_details.MovieDetails
import com.zaurh.movietimenew.presentation.model.MovieDetailsUIModel
import com.zaurh.movietimenew.util.time

fun MovieDetails.toUIModel(): MovieDetailsUIModel {
    return MovieDetailsUIModel(
        id = this.id,
        runtime = time(this.runtime),
        posterPath = this.poster,
        overview = this.overview,
        genres = this.genres,
        releaseDate = this.releaseDate,
        title = this.title
    )
}

fun MovieDetailsUIModel.toDomain(): MovieDetails {
    return MovieDetails(
        id = this.id,
        poster = this.posterPath,
        title = this.title
    )
}