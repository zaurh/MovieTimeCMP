package com.zaurh.movietimenew.data.mapper.search

import com.zaurh.movietimenew.data.models.search.multi.SearchMultiDTO
import com.zaurh.movietimenew.data.models.search.multi.SearchMultiItemDTO
import com.zaurh.movietimenew.data.models.search.multi.SearchMultiKnownForDTO
import com.zaurh.movietimenew.domain.models.search.multi.SearchMulti
import com.zaurh.movietimenew.domain.models.search.multi.SearchMultiItem
import com.zaurh.movietimenew.domain.models.search.multi.SearchMultiKnownFor
import com.zaurh.movietimenew.util.generateImagePath
import com.zaurh.movietimenew.util.orFalse
import com.zaurh.movietimenew.util.orZero

fun SearchMultiDTO.toDomain(): SearchMulti {
    return SearchMulti(
        page = this.page.orZero(),
        results = this.results?.map { it.toDomain() }.orEmpty(),
        totalPages = this.total_pages.orZero(),
        totalResults = this.total_results.orZero()
    )
}

fun SearchMultiItemDTO.toDomain(): SearchMultiItem {
    return SearchMultiItem(
        id = this.id.orZero(),
        mediaType = this.media_type.orEmpty(),
        popularity = this.popularity.orZero(),
        adult = this.adult.orFalse(),
        title = this.title.orEmpty(),
        name = this.name.orEmpty(),
        originalTitle = this.original_title.orEmpty(),
        originalName = this.original_name.orEmpty(),
        overview = this.overview.orEmpty(),
        posterPath = generateImagePath(this.poster_path),
        backdropPath = this.backdrop_path.orEmpty(),
        genreIds = this.genre_ids.orEmpty(),
        originalLanguage = this.original_language.orEmpty(),
        voteAverage = this.vote_average.orZero(),
        voteCount = this.vote_count.orZero(),
        releaseDate = this.release_date.orEmpty(),
        video = this.video.orFalse(),
        firstAirDate = this.first_air_date.orEmpty(),
        originCountry = this.origin_country.orEmpty(),
        gender = this.gender.orZero(),
        knownForDepartment = this.known_for_department.orEmpty(),
        profilePath = generateImagePath(this.profile_path),
        knownFor = this.known_for?.map { it.toDomain() }.orEmpty()
    )
}

fun SearchMultiKnownForDTO.toDomain(): SearchMultiKnownFor {
    return SearchMultiKnownFor(
        id = this.id.orZero(),
        mediaType = this.media_type.orEmpty(),
        title = this.title.orEmpty(),
        name = this.name.orEmpty(),
        originalTitle = this.original_title.orEmpty(),
        originalName = this.original_name.orEmpty(),
        overview = this.overview.orEmpty(),
        posterPath = generateImagePath(this.poster_path),
        backdropPath = generateImagePath(this.backdrop_path),
        genreIds = this.genre_ids.orEmpty(),
        originalLanguage = this.original_language.orEmpty(),
        popularity = this.popularity.orZero(),
        voteAverage = this.vote_average.orZero(),
        voteCount = this.vote_count.orZero(),
        releaseDate = this.release_date.orEmpty(),
        firstAirDate = this.first_air_date.orEmpty()
    )
}