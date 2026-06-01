package com.zaurh.movietimenew.data.mapper.trending

import com.zaurh.movietimenew.data.models.trending.person.TrendingPeopleDTO
import com.zaurh.movietimenew.data.models.trending.person.TrendingPeopleItemDTO
import com.zaurh.movietimenew.data.models.trending.person.TrendingPeopleKnownForDTO
import com.zaurh.movietimenew.domain.models.search.multi.SearchMultiItem
import com.zaurh.movietimenew.domain.models.trending.person.TrendingPeople
import com.zaurh.movietimenew.domain.models.trending.person.TrendingPeopleItem
import com.zaurh.movietimenew.domain.models.trending.person.TrendingPeopleKnownFor
import com.zaurh.movietimenew.util.generateImagePath
import com.zaurh.movietimenew.util.orFalse
import com.zaurh.movietimenew.util.orZero

fun TrendingPeopleDTO.toDomain(): TrendingPeople {
    return TrendingPeople(
        page = this.page.orZero(),
        results = this.results?.map { it.toDomain() }.orEmpty(),
        totalPages = this.total_pages.orZero(),
        totalResults = this.total_results.orZero()
    )
}

fun TrendingPeopleItemDTO.toDomain(): TrendingPeopleItem {
    return TrendingPeopleItem(
        adult = this.adult.orFalse(),
        id = this.id.orZero(),
        name = this.name.orEmpty(),
        originalName = this.original_name.orEmpty(),
        title = this.title.orEmpty(),
        originalLanguage = this.original_language.orEmpty(),
        originalTitle = this.original_title.orEmpty(),
        overview = this.overview.orEmpty(),
        posterPath = generateImagePath(this.poster_path),
        backdropPath = generateImagePath(this.backdrop_path),
        mediaType = this.media_type.orEmpty(),
        genreIds = this.genre_ids.orEmpty(),
        popularity = this.popularity.orZero(),
        releaseDate = this.release_date.orEmpty(),
        firstAirDate = this.first_air_date.orEmpty(),
        video = this.video.orFalse(),
        voteAverage = this.vote_average.orZero(),
        voteCount = this.vote_count.orZero(),
        gender = this.gender.orZero(),
        knownForDepartment = this.known_for_department.orEmpty(),
        profilePath = generateImagePath(this.profile_path),
        knownFor = this.known_for?.map { it.toDomain() }.orEmpty(),
        originCountry = this.origin_country.orEmpty()
    )
}

fun TrendingPeopleKnownForDTO.toDomain(): TrendingPeopleKnownFor {
    return TrendingPeopleKnownFor(
        adult = this.adult.orFalse(),
        backdropPath = generateImagePath(this.backdrop_path),
        id = this.id.orZero(),
        title = this.title.orEmpty(),
        name = this.name.orEmpty(),
        originalLanguage = this.original_language.orEmpty(),
        originalTitle = this.original_title.orEmpty(),
        originalName = this.original_name.orEmpty(),
        overview = this.overview.orEmpty(),
        posterPath = generateImagePath(this.poster_path),
        mediaType = this.media_type.orEmpty(),
        genreIds = this.genre_ids.orEmpty(),
        popularity = this.popularity.orZero(),
        releaseDate = this.release_date.orEmpty(),
        firstAirDate = this.first_air_date.orEmpty(),
        video = this.video.orFalse(),
        voteAverage = this.vote_average.orZero(),
        voteCount = this.vote_count.orZero(),
        originCountry = this.origin_country.orEmpty()
    )
}

fun TrendingPeopleItem.toMultiItem(): SearchMultiItem {
    return SearchMultiItem(
        adult = this.adult,
        backdropPath = this.backdropPath,
        genreIds = this.genreIds,
        id = this.id,
        originalLanguage = this.originalLanguage,
        originalTitle = this.originalTitle,
        overview = this.overview,
        popularity = this.popularity,
        posterPath = this.posterPath.ifEmpty { this.profilePath },
        releaseDate = this.releaseDate.ifEmpty { this.firstAirDate },
        title = this.title.ifEmpty { this.name },
        video = this.video,
        voteAverage = this.voteAverage,
        voteCount = this.voteCount,
        mediaType = this.mediaType,
    )
}