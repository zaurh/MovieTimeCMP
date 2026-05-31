package com.zaurh.movieappintern2.data.mapper.movie

import com.zaurh.movietimenew.data.models.movie.movie_popular.PopularMoviesDTO
import com.zaurh.movietimenew.data.models.movie.movie_popular.PopularMoviesItemDTO
import com.zaurh.movietimenew.domain.models.movie.movie_popular.PopularMovies
import com.zaurh.movietimenew.domain.models.movie.movie_popular.PopularMoviesItem
import com.zaurh.movietimenew.util.generateImagePath
import com.zaurh.movietimenew.util.orFalse
import com.zaurh.movietimenew.util.orZero
import kotlin.collections.orEmpty
import kotlin.text.orEmpty

fun PopularMoviesDTO.toDomain(): PopularMovies {
    return PopularMovies(
        page = this.page.orZero(),
        results = this.results.map { it.toDomain() },
        totalPages = this.total_pages.orZero(),
        totalResults = this.total_results.orZero()
    )
}

fun PopularMoviesItemDTO.toDomain(): PopularMoviesItem {
    return PopularMoviesItem(
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