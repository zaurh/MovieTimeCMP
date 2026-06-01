package com.zaurh.movietimenew.data.mapper.trending

import com.zaurh.movietimenew.data.models.trending.tv.TrendingTvDTO
import com.zaurh.movietimenew.data.models.trending.tv.TrendingTvItemDTO
import com.zaurh.movietimenew.domain.models.search.multi.SearchMultiItem
import com.zaurh.movietimenew.domain.models.trending.tv.TrendingTv
import com.zaurh.movietimenew.domain.models.trending.tv.TrendingTvItem
import com.zaurh.movietimenew.util.generateImagePath
import com.zaurh.movietimenew.util.orFalse
import com.zaurh.movietimenew.util.orZero

fun TrendingTvDTO.toDomain(): TrendingTv {
    return TrendingTv(
        page = this.page.orZero(),
        results = this.results?.map { it.toDomain() }.orEmpty(),
        totalPages = this.total_pages.orZero(),
        totalResults = this.total_results.orZero()
    )
}

fun TrendingTvItemDTO.toDomain(): TrendingTvItem {
    return TrendingTvItem(
        adult = this.adult.orFalse(),
        backdropPath = generateImagePath(this.backdrop_path),
        id = this.id.orZero(),
        name = this.name.orEmpty(),
        originalLanguage = this.original_language.orEmpty(),
        originalName = this.original_name.orEmpty(),
        overview = this.overview.orEmpty(),
        posterPath = generateImagePath(this.poster_path),
        mediaType = this.media_type.orEmpty(),
        genreIds = this.genre_ids.orEmpty(),
        popularity = this.popularity.orZero(),
        firstAirDate = this.first_air_date.orEmpty(),
        voteAverage = this.vote_average.orZero(),
        voteCount = this.vote_count.orZero(),
        originCountry = this.origin_country.orEmpty()
    )
}

fun TrendingTvItem.toMultiItem(): SearchMultiItem {
    return SearchMultiItem(
        adult = this.adult,
        backdropPath = this.backdropPath,
        genreIds = this.genreIds,
        id = this.id,
        originalLanguage = this.originalLanguage,
        overview = this.overview,
        popularity = this.popularity,
        posterPath = this.posterPath,
        releaseDate = this.firstAirDate,
        title = this.name,
        voteAverage = this.voteAverage,
        voteCount = this.voteCount,
        mediaType = this.mediaType,
    )
}