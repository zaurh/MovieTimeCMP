package com.zaurh.movieappintern2.data.mapper.movie

import com.zaurh.movietimenew.data.models.movie.movie_upcoming.UpcomingMoviesDTO
import com.zaurh.movietimenew.data.models.movie.movie_upcoming.UpcomingMoviesDatesDTO
import com.zaurh.movietimenew.data.models.movie.movie_upcoming.UpcomingMoviesItemDTO
import com.zaurh.movietimenew.domain.models.movie.movie_upcoming.UpcomingMovies
import com.zaurh.movietimenew.domain.models.movie.movie_upcoming.UpcomingMoviesDates
import com.zaurh.movietimenew.domain.models.movie.movie_upcoming.UpcomingMoviesItem
import com.zaurh.movietimenew.util.generateImagePath
import com.zaurh.movietimenew.util.orFalse
import com.zaurh.movietimenew.util.orZero
import kotlin.collections.orEmpty

fun UpcomingMoviesDTO.toDomain(): UpcomingMovies {
    return UpcomingMovies(
        dates = this.dates.toDomain(),
        page = this.page.orZero(),
        results = this.results.map { it.toDomain() },
        totalPages = this.total_pages.orZero(),
        totalResults = this.total_results.orZero()
    )
}

fun UpcomingMoviesDatesDTO?.toDomain(): UpcomingMoviesDates {
    return UpcomingMoviesDates(
        maximum = this?.maximum.orEmpty(),
        minimum = this?.minimum.orEmpty()
    )
}

fun UpcomingMoviesItemDTO.toDomain(): UpcomingMoviesItem {
    return UpcomingMoviesItem(
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