package com.zaurh.movietimenew.data.mapper.search

import com.zaurh.movietimenew.data.models.search.movies.SearchMovieItemDTO
import com.zaurh.movietimenew.data.models.search.movies.SearchMoviesDTO
import com.zaurh.movietimenew.domain.models.search.movies.SearchMovieItem
import com.zaurh.movietimenew.domain.models.search.movies.SearchMovies
import com.zaurh.movietimenew.domain.models.search.multi.SearchMultiItem
import com.zaurh.movietimenew.util.generateImagePath
import com.zaurh.movietimenew.util.orFalse
import com.zaurh.movietimenew.util.orZero

fun SearchMoviesDTO.toDomain(): SearchMovies {
    return SearchMovies(
        page = this.page.orZero(),
        results = this.results?.map { it.toDomain() }.orEmpty(),
        totalPages = this.total_pages.orZero(),
        totalResults = this.total_results.orZero()
    )
}

fun SearchMovieItemDTO.toDomain(): SearchMovieItem {
    return SearchMovieItem(
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
        voteCount = this.vote_count.orZero(),
    )
}

fun SearchMovieItem.toMultiItem(): SearchMultiItem {
    return SearchMultiItem(
        adult = this.adult,
        backdropPath = this.backdropPath,
        genreIds = this.genreIds,
        id = this.id,
        originalLanguage = this.originalLanguage,
        originalTitle = this.originalTitle,
        overview = this.overview,
        popularity = this.popularity,
        posterPath = this.posterPath,
        releaseDate = this.releaseDate,
        title = this.title,
        video = this.video,
        voteAverage = this.voteAverage,
        voteCount = this.voteCount,
        mediaType = "movie",
    )
}