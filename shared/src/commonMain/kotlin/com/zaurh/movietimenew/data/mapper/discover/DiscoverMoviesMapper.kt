package com.zaurh.movietimenew.data.mapper.discover

import com.zaurh.movietimenew.data.models.discover.discover_movie.DiscoverMoviesDTO
import com.zaurh.movietimenew.data.models.discover.discover_movie.DiscoverMoviesItemDTO
import com.zaurh.movietimenew.domain.discover.discover_movies.DiscoverMovies
import com.zaurh.movietimenew.domain.discover.discover_movies.DiscoverMoviesItem
import com.zaurh.movietimenew.util.generateImagePath
import com.zaurh.movietimenew.util.orFalse
import com.zaurh.movietimenew.util.orZero

fun DiscoverMoviesDTO.toDomain(): DiscoverMovies {
    return DiscoverMovies(
        page = this.page.orZero(),
        results = this.results?.map { it.toDomain() }.orEmpty(),
        totalPages = this.total_pages.orZero(),
        totalResults = this.total_results.orZero()
    )
}

fun DiscoverMoviesItemDTO.toDomain(): DiscoverMoviesItem {
    return DiscoverMoviesItem(
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