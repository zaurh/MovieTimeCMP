package com.zaurh.movietimenew.data.mapper.search

import com.zaurh.movietimenew.data.models.search.person.SearchPersonDTO
import com.zaurh.movietimenew.data.models.search.person.SearchPersonItemDTO
import com.zaurh.movietimenew.data.models.search.person.SearchPersonKnownForDTO
import com.zaurh.movietimenew.domain.models.search.multi.SearchMultiItem
import com.zaurh.movietimenew.domain.models.search.person.SearchPerson
import com.zaurh.movietimenew.domain.models.search.person.SearchPersonItem
import com.zaurh.movietimenew.domain.models.search.person.SearchPersonKnownFor
import com.zaurh.movietimenew.util.generateImagePath
import com.zaurh.movietimenew.util.orFalse
import com.zaurh.movietimenew.util.orZero

fun SearchPersonDTO.toDomain(): SearchPerson {
    return SearchPerson(
        page = this.page.orZero(),
        results = this.results?.map { it.toDomain() }.orEmpty(),
        totalPages = this.total_pages.orZero(),
        totalResults = this.total_results.orZero()
    )
}

fun SearchPersonItemDTO.toDomain(): SearchPersonItem {
    return SearchPersonItem(
        id = this.id.orZero(),
        name = this.name.orEmpty(),
        originalName = this.original_name.orEmpty(),
        gender = this.gender.orZero(),
        knownForDepartment = this.known_for_department.orEmpty(),
        popularity = this.popularity.orZero(),
        profilePath = generateImagePath(this.profile_path),
        adult = this.adult.orFalse(),
        knownFor = this.known_for?.map { it.toDomain() }.orEmpty()
    )
}

fun SearchPersonKnownForDTO.toDomain(): SearchPersonKnownFor {
    return SearchPersonKnownFor(
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

fun SearchPersonItem.toMultiItem(): SearchMultiItem {
    return SearchMultiItem(
        id = this.id,
        name = this.name,
        originalName = this.originalName,
        gender = this.gender,
        knownForDepartment = this.knownForDepartment,
        popularity = this.popularity,
        profilePath = this.profilePath,
        adult = this.adult,
        mediaType = "person"
    )
}