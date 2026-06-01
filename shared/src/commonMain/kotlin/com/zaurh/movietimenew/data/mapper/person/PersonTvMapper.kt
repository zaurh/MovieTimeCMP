package com.zaurh.movietimenew.data.mapper.person

import com.zaurh.movietimenew.data.models.person.person_tv.PersonTvCastDTO
import com.zaurh.movietimenew.data.models.person.person_tv.PersonTvCrewDTO
import com.zaurh.movietimenew.data.models.person.person_tv.PersonTvDTO
import com.zaurh.movietimenew.domain.models.person.person_tv.PersonTv
import com.zaurh.movietimenew.domain.models.person.person_tv.PersonTvCastItem
import com.zaurh.movietimenew.domain.models.person.person_tv.PersonTvCrewItem
import com.zaurh.movietimenew.util.generateImagePath
import com.zaurh.movietimenew.util.orFalse
import com.zaurh.movietimenew.util.orZero

fun PersonTvDTO.toDomain(): PersonTv {
    return PersonTv(
        cast = cast?.map { it.toDomain() }.orEmpty(),
        crew = crew?.map { it.toDomain() }.orEmpty(),
        id = id.orZero()
    )
}

fun PersonTvCastDTO.toDomain(): PersonTvCastItem {
    return PersonTvCastItem(
        adult = adult.orFalse(),
        backdropPath = generateImagePath(this.backdrop_path),
        genreIds = genre_ids.orEmpty(),
        id = id.orZero(),
        originCountry = origin_country.orEmpty(),
        originalLanguage = original_language.orEmpty(),
        originalName = original_name.orEmpty(),
        overview = overview.orEmpty(),
        popularity = popularity.orZero(),
        posterPath = generateImagePath(this.poster_path),
        firstAirDate = first_air_date.orEmpty(),
        softcore = softcore.orFalse(),
        name = name.orEmpty(),
        voteAverage = vote_average.orZero(),
        voteCount = vote_count.orZero(),
        character = character.orEmpty(),
        creditId = credit_id.orEmpty(),
        episodeCount = episode_count.orZero(),
        firstCreditAirDate = first_credit_air_date.orEmpty()
    )
}

fun PersonTvCrewDTO.toDomain(): PersonTvCrewItem {
    return PersonTvCrewItem(
        adult = adult.orFalse(),
        backdropPath = generateImagePath(this.backdrop_path),
        genreIds = genre_ids.orEmpty(),
        id = id.orZero(),
        originCountry = origin_country.orEmpty(),
        originalLanguage = original_language.orEmpty(),
        originalName = original_name.orEmpty(),
        overview = overview.orEmpty(),
        popularity = popularity.orZero(),
        posterPath = generateImagePath(this.poster_path),
        firstAirDate = first_air_date.orEmpty(),
        softcore = softcore.orFalse(),
        name = name.orEmpty(),
        voteAverage = vote_average.orZero(),
        voteCount = vote_count.orZero(),
        creditId = credit_id.orEmpty()
    )
}