package com.zaurh.movieappintern2.data.mapper.movie

import com.zaurh.movietimenew.data.models.movie.movie_top_rated.TopRatedMoviesDTO
import com.zaurh.movietimenew.data.models.movie.movie_top_rated.TopRatedMoviesItemDTO
import com.zaurh.movietimenew.domain.models.movie.movie_top_rated.TopRatedMovies
import com.zaurh.movietimenew.domain.models.movie.movie_top_rated.TopRatedMoviesItem
import com.zaurh.movietimenew.util.generateImagePath
import com.zaurh.movietimenew.util.orFalse
import com.zaurh.movietimenew.util.orZero

fun TopRatedMoviesDTO.toDomain(): TopRatedMovies {
    return TopRatedMovies(
        page = this.page.orZero(),
        results = this.results?.map { it.toDomain() }.orEmpty(),
        totalPages = this.total_pages.orZero(),
        totalResults = this.total_results.orZero()
    )
}

fun TopRatedMoviesItemDTO.toDomain(): TopRatedMoviesItem {
    return TopRatedMoviesItem(
        adult = this.adult.orFalse(),
        backdropPath = generateImagePath(this.backdrop_path),
        genreIds = this.genre_ids.orEmpty(),
        id = this.id.orZero(),
        originalLanguage = this.original_language.orEmpty(),
        originalTitle = this.original_title.orEmpty(),
        overview = this.overview.orEmpty(),
        popularity = this.popularity.orZero(),
        posterPath = generateImagePath(this.poster_path),
        releaseDate = this.release_date.orEmpty(),
        title = this.title.orEmpty(),
        video = this.video.orFalse(),
        voteAverage = this.vote_average.orZero(),
        voteCount = this.vote_count.orZero()
    )
}