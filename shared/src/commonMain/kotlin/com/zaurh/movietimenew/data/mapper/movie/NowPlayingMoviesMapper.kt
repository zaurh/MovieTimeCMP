package com.zaurh.movieappintern2.data.mapper.movie

import com.zaurh.movietimenew.data.models.movie.movie_now_playing.NowPlayingMoviesDTO
import com.zaurh.movietimenew.data.models.movie.movie_now_playing.NowPlayingMoviesDatesDTO
import com.zaurh.movietimenew.data.models.movie.movie_now_playing.NowPlayingMoviesItemDTO
import com.zaurh.movietimenew.domain.models.movie.movie_now_playing.NowPlayingMovies
import com.zaurh.movietimenew.domain.models.movie.movie_now_playing.NowPlayingMoviesDates
import com.zaurh.movietimenew.domain.models.movie.movie_now_playing.NowPlayingMoviesItem
import com.zaurh.movietimenew.util.generateImagePath
import com.zaurh.movietimenew.util.orFalse
import com.zaurh.movietimenew.util.orZero
import kotlin.collections.orEmpty
import kotlin.text.orEmpty

fun NowPlayingMoviesDTO.toDomain(): NowPlayingMovies {
    return NowPlayingMovies(
        dates = this.dates.toDomain(),
        page = this.page.orZero(),
        results = this.results?.map { it.toDomain() }.orEmpty(),
        totalPages = this.total_pages.orZero(),
        totalResults = this.total_results.orZero()
    )
}

fun NowPlayingMoviesDatesDTO?.toDomain(): NowPlayingMoviesDates {
    return NowPlayingMoviesDates(
        maximum = this?.maximum.orEmpty(),
        minimum = this?.minimum.orEmpty()
    )
}

fun NowPlayingMoviesItemDTO.toDomain(): NowPlayingMoviesItem {
    return NowPlayingMoviesItem(
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