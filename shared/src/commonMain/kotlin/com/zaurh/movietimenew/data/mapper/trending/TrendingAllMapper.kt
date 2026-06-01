package com.zaurh.movietimenew.data.mapper.trending

import com.zaurh.movietimenew.data.models.trending.all.TrendingAllDTO
import com.zaurh.movietimenew.data.models.trending.all.TrendingAllItemDTO
import com.zaurh.movietimenew.data.models.trending.all.TrendingAllKnownForDTO
import com.zaurh.movietimenew.domain.models.search.multi.SearchMultiItem
import com.zaurh.movietimenew.domain.models.trending.all.TrendingAll
import com.zaurh.movietimenew.domain.models.trending.all.TrendingAllItem
import com.zaurh.movietimenew.domain.models.trending.all.TrendingAllKnownFor
import com.zaurh.movietimenew.util.generateImagePath
import com.zaurh.movietimenew.util.orFalse
import com.zaurh.movietimenew.util.orZero

fun TrendingAllDTO.toDomain(): TrendingAll {
    return TrendingAll(
        page = this.page.orZero(),
        results = this.results?.map { it.toDomain() }.orEmpty(),
        totalPages = this.total_pages.orZero(),
        totalResults = this.total_results.orZero()
    )
}

fun TrendingAllItemDTO.toDomain(): TrendingAllItem {
    return TrendingAllItem(
        adult = this.adult.orFalse(),
        backdropPath = generateImagePath(this.backdrop_path),
        id = this.id.orZero(),
        title = this.title.orEmpty(),
        originalTitle = this.original_title.orEmpty(),
        releaseDate = this.release_date.orEmpty(),
        video = this.video.orFalse(),
        name = this.name.orEmpty(),
        originalName = this.original_name.orEmpty(),
        originalLanguage = this.original_language.orEmpty(),
        overview = this.overview.orEmpty(),
        posterPath = generateImagePath(this.poster_path),
        profilePath = generateImagePath(this.profile_path),
        mediaType = this.media_type.orEmpty(),
        genreIds = this.genre_ids.orEmpty(),
        popularity = this.popularity.orZero(),
        voteAverage = this.vote_average.orZero(),
        voteCount = this.vote_count.orZero(),
        firstAirDate = this.first_air_date.orEmpty(),
        originCountry = this.origin_country.orEmpty(),
        gender = this.gender.orZero(),
        knownForDepartment = this.known_for_department.orEmpty(),
        knownFor = this.known_for?.map { it.toDomain() }.orEmpty()
    )
}

fun TrendingAllKnownForDTO.toDomain(): TrendingAllKnownFor {
    return TrendingAllKnownFor(
        adult = this.adult.orFalse(),
        backdropPath = this.backdrop_path.orEmpty(),
        id = this.id.orZero(),
        title = this.title.orEmpty(),
        originalTitle = this.original_title.orEmpty(),
        releaseDate = this.release_date.orEmpty(),
        video = this.video.orFalse(),
        name = this.name.orEmpty(),
        originalName = this.original_name.orEmpty(),
        firstAirDate = this.first_air_date.orEmpty(),
        originCountry = this.origin_country.orEmpty(),
        originalLanguage = this.original_language.orEmpty(),
        overview = this.overview.orEmpty(),
        posterPath = this.poster_path.orEmpty(),
        mediaType = this.media_type.orEmpty(),
        genreIds = this.genre_ids.orEmpty(),
        popularity = this.popularity.orZero(),
        voteAverage = this.vote_average.orZero(),
        voteCount = this.vote_count.orZero()
    )
}

fun TrendingAllItem.toMultiItem(): SearchMultiItem {
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
        releaseDate = this.releaseDate.ifEmpty { this.firstAirDate },
        title = this.title.ifEmpty { this.name },
        video = this.video,
        voteAverage = this.voteAverage,
        voteCount = this.voteCount,
        mediaType = this.mediaType,
    )
}