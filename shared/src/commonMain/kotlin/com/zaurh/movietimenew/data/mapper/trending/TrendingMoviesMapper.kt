package com.zaurh.movietimenew.data.mapper.trending

import com.zaurh.movietimenew.data.models.trending.movie.TrendingMoviesDTO
import com.zaurh.movietimenew.data.models.trending.movie.TrendingMoviesItemDTO
import com.zaurh.movietimenew.domain.models.search.multi.SearchMultiItem
import com.zaurh.movietimenew.domain.models.trending.movie.TrendingMovies
import com.zaurh.movietimenew.domain.models.trending.movie.TrendingMoviesItem
import com.zaurh.movietimenew.util.generateImagePath
import com.zaurh.movietimenew.util.orFalse
import com.zaurh.movietimenew.util.orZero

fun TrendingMoviesDTO.toDomain(): TrendingMovies {
    return TrendingMovies(
        page = this.page.orZero(),
        results = this.results?.map { it.toDomain() }.orEmpty(),
        totalPages = this.total_pages.orZero(),
        totalResults = this.total_results.orZero()
    )
}

fun TrendingMoviesItemDTO.toDomain(): TrendingMoviesItem {
    return TrendingMoviesItem(
        adult = this.adult.orFalse(),
        backdropPath = generateImagePath(this.backdrop_path),
        id = this.id.orZero(),
        title = this.title.orEmpty(),
        originalLanguage = this.original_language.orEmpty(),
        originalTitle = this.original_title.orEmpty(),
        overview = this.overview.orEmpty(),
        posterPath = generateImagePath(this.poster_path),
        mediaType = this.media_type.orEmpty(),
        genreIds = this.genre_ids.orEmpty(),
        popularity = this.popularity.orZero(),
        releaseDate = this.release_date.orEmpty(),
        video = this.video.orFalse(),
        voteAverage = this.vote_average.orZero(),
        voteCount = this.vote_count.orZero()
    )
}

fun TrendingMoviesItem.toMultiItem(): SearchMultiItem {
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
        mediaType = this.mediaType,
    )
}