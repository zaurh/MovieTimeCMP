package com.zaurh.movietimenew.data.mapper.person

import com.zaurh.movietimenew.data.models.person.person_popular.PersonPopularDTO
import com.zaurh.movietimenew.data.models.person.person_popular.PersonPopularItemDTO
import com.zaurh.movietimenew.data.models.person.person_popular.PersonPopularKnownForDTO
import com.zaurh.movietimenew.domain.models.person.person_popular.PersonPopular
import com.zaurh.movietimenew.domain.models.person.person_popular.PersonPopularItem
import com.zaurh.movietimenew.domain.models.person.person_popular.PersonPopularKnownFor
import com.zaurh.movietimenew.util.generateImagePath
import com.zaurh.movietimenew.util.orFalse
import com.zaurh.movietimenew.util.orZero

fun PersonPopularDTO.toDomain(): PersonPopular {
    return PersonPopular(
        page = page.orZero(),
        results = results?.map { it.toDomain() }.orEmpty(),
        totalPages = total_pages.orZero(),
        totalResults = total_results.orZero()
    )
}

fun PersonPopularItemDTO.toDomain(): PersonPopularItem {
    return PersonPopularItem(
        adult = adult.orFalse(),
        gender = gender.orZero(),
        id = id.orZero().toLong(),
        knownForDepartment = known_for_department.orEmpty(),
        name = name.orEmpty(),
        originalName = original_name.orEmpty(),
        popularity = popularity.orZero(),
        profilePath = generateImagePath(this.profile_path),
        knownFor = known_for?.map { it.toDomain() }.orEmpty()
    )
}

fun PersonPopularKnownForDTO.toDomain(): PersonPopularKnownFor {
    return PersonPopularKnownFor(
        adult = adult.orFalse(),
        backdropPath = generateImagePath(this.backdrop_path),
        id = id.orZero().toLong(),
        title = title.orEmpty(),
        originalTitle = original_title.orEmpty(),
        overview = overview.orEmpty(),
        posterPath = generateImagePath(this.poster_path),
        mediaType = media_type.orEmpty(),
        originalLanguage = original_language.orEmpty(),
        genreIds = genre_ids.orEmpty(),
        popularity = popularity.orZero(),
        releaseDate = release_date.orEmpty(),
        softcore = softcore.orFalse(),
        video = video.orFalse(),
        voteAverage = vote_average.orZero(),
        voteCount = vote_count.orZero()
    )
}