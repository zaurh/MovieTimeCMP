package com.zaurh.movietimenew.data.mapper.search

import com.zaurh.movietimenew.data.models.search.tv.SearchTvDTO
import com.zaurh.movietimenew.data.models.search.tv.SearchTvItemDTO
import com.zaurh.movietimenew.domain.models.search.multi.SearchMultiItem
import com.zaurh.movietimenew.domain.models.search.tv.SearchTv
import com.zaurh.movietimenew.domain.models.search.tv.SearchTvItem
import com.zaurh.movietimenew.util.generateImagePath
import com.zaurh.movietimenew.util.orFalse
import com.zaurh.movietimenew.util.orZero

fun SearchTvDTO.toDomain(): SearchTv {
    return SearchTv(
        page = this.page.orZero(),
        results = this.results?.map { it.toDomain() }.orEmpty(),
        totalPages = this.total_pages.orZero(),
        totalResults = this.total_results.orZero()
    )
}

fun SearchTvItemDTO.toDomain(): SearchTvItem {
    return SearchTvItem(
        adult = this.adult.orFalse(),
        backdropPath = generateImagePath(this.backdrop_path),
        genreIds = this.genre_ids.orEmpty(),
        id = this.id.orZero(),
        originCountry = this.origin_country.orEmpty(),
        originalLanguage = this.original_language.orEmpty(),
        originalName = this.original_name.orEmpty(),
        overview = this.overview.orEmpty(),
        popularity = this.popularity.orZero(),
        posterPath = generateImagePath(this.poster_path),
        firstAirDate = this.first_air_date.orEmpty(),
        softcore = this.softcore.orFalse(),
        name = this.name.orEmpty(),
        voteAverage = this.vote_average.orZero(),
        voteCount = this.vote_count.orZero(),
    )
}

fun SearchTvItem.toMultiItem(): SearchMultiItem {
    return SearchMultiItem(
        id = this.id.orZero(),
        mediaType = "tv",
        popularity = this.popularity,
        adult = this.adult,
        title = this.name,
        name = this.name,
        originalTitle = this.originalName,
        originalName = this.originalName,
        overview = this.overview,
        posterPath = this.posterPath,
        backdropPath = this.backdropPath,
        genreIds = this.genreIds,
        originalLanguage = this.originalLanguage,
        voteAverage = this.voteAverage,
        voteCount = this.voteCount,
        releaseDate = this.firstAirDate,
        firstAirDate = this.firstAirDate,
        originCountry = this.originCountry
    )
}