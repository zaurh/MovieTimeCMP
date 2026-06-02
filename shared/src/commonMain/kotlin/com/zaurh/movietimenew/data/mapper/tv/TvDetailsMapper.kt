package com.zaurh.movietimenew.data.mapper.tv

import com.zaurh.movietimenew.data.models.tv.tv_details.TvDetailsCreatedByDTO
import com.zaurh.movietimenew.data.models.tv.tv_details.TvDetailsDTO
import com.zaurh.movietimenew.data.models.tv.tv_details.TvDetailsEpisodeDTO
import com.zaurh.movietimenew.data.models.tv.tv_details.TvDetailsGenreDTO
import com.zaurh.movietimenew.data.models.tv.tv_details.TvDetailsNetworkDTO
import com.zaurh.movietimenew.data.models.tv.tv_details.TvDetailsProductionCompanyDTO
import com.zaurh.movietimenew.data.models.tv.tv_details.TvDetailsProductionCountryDTO
import com.zaurh.movietimenew.data.models.tv.tv_details.TvDetailsSeasonDTO
import com.zaurh.movietimenew.data.models.tv.tv_details.TvDetailsSpokenLanguageDTO
import com.zaurh.movietimenew.domain.models.tv.tv_details.TvDetails
import com.zaurh.movietimenew.domain.models.tv.tv_details.TvDetailsCreatedBy
import com.zaurh.movietimenew.domain.models.tv.tv_details.TvDetailsEpisode
import com.zaurh.movietimenew.domain.models.tv.tv_details.TvDetailsGenre
import com.zaurh.movietimenew.domain.models.tv.tv_details.TvDetailsNetwork
import com.zaurh.movietimenew.domain.models.tv.tv_details.TvDetailsProductionCompany
import com.zaurh.movietimenew.domain.models.tv.tv_details.TvDetailsProductionCountry
import com.zaurh.movietimenew.domain.models.tv.tv_details.TvDetailsSeason
import com.zaurh.movietimenew.domain.models.tv.tv_details.TvDetailsSpokenLanguage
import com.zaurh.movietimenew.util.generateImagePath
import com.zaurh.movietimenew.util.orFalse
import com.zaurh.movietimenew.util.orZero

fun TvDetailsDTO.toDomain(): TvDetails {
    return TvDetails(
        adult = this.adult.orFalse(),
        backdropPath = generateImagePath(this.backdrop_path),
        createdBy = this.created_by?.map { it.toDomain() }.orEmpty(),
        episodeRunTime = this.episode_run_time.orEmpty(),
        firstAirDate = this.first_air_date.orEmpty(),
        genres = this.genres?.map { it.toDomain() }.orEmpty(),
        homepage = this.homepage.orEmpty(),
        id = this.id.orZero(),
        inProduction = this.in_production.orFalse(),
        languages = this.languages.orEmpty(),
        lastAirDate = this.last_air_date.orEmpty(),
        lastEpisodeToAir = this.last_episode_to_air.toDomain(),
        name = this.name.orEmpty(),
        nextEpisodeToAir = this.next_episode_to_air.toDomain(),
        networks = this.networks?.map { it.toDomain() }.orEmpty(),
        numberOfEpisodes = this.number_of_episodes.orZero(),
        numberOfSeasons = this.number_of_seasons.orZero(),
        originCountry = this.origin_country.orEmpty(),
        originalLanguage = this.original_language.orEmpty(),
        originalName = this.original_name.orEmpty(),
        overview = this.overview.orEmpty(),
        popularity = this.popularity.orZero(),
        posterPath = generateImagePath(this.poster_path),
        productionCompanies = this.production_companies?.map { it.toDomain() }.orEmpty(),
        productionCountries = this.production_countries?.map { it.toDomain() }.orEmpty(),
        seasons = this.seasons?.map { it.toDomain() }.orEmpty(),
        spokenLanguages = this.spoken_languages?.map { it.toDomain() }.orEmpty(),
        status = this.status.orEmpty(),
        tagline = this.tagline.orEmpty(),
        type = this.type.orEmpty(),
        voteAverage = this.vote_average.orZero(),
        voteCount = this.vote_count.orZero()
    )
}

fun TvDetailsCreatedByDTO.toDomain(): TvDetailsCreatedBy {
    return TvDetailsCreatedBy(
        id = this.id.orZero(),
        creditId = this.credit_id.orEmpty(),
        name = this.name.orEmpty(),
        gender = this.gender.orZero(),
        profilePath = generateImagePath(this.profile_path)
    )
}

fun TvDetailsEpisodeDTO?.toDomain(): TvDetailsEpisode {
    return TvDetailsEpisode(
        id = this?.id.orZero(),
        name = this?.name.orEmpty(),
        overview = this?.overview.orEmpty(),
        voteAverage = this?.vote_average.orZero(),
        voteCount = this?.vote_count.orZero(),
        airDate = this?.air_date.orEmpty(),
        episodeNumber = this?.episode_number.orZero(),
        productionCode = this?.production_code.orEmpty(),
        runtime = this?.runtime.orZero(),
        seasonNumber = this?.season_number.orZero(),
        showId = this?.show_id.orZero(),
        stillPath = generateImagePath(this?.still_path)
    )
}

fun TvDetailsGenreDTO.toDomain(): TvDetailsGenre {
    return TvDetailsGenre(
        id = this.id.orZero(),
        name = this.name.orEmpty()
    )
}

fun TvDetailsNetworkDTO.toDomain(): TvDetailsNetwork {
    return TvDetailsNetwork(
        id = this.id.orZero(),
        logoPath = generateImagePath(this.logo_path),
        name = this.name.orEmpty(),
        originCountry = this.origin_country.orEmpty()
    )
}

fun TvDetailsProductionCompanyDTO.toDomain(): TvDetailsProductionCompany {
    return TvDetailsProductionCompany(
        id = this.id.orZero(),
        logoPath = generateImagePath(this.logo_path),
        name = this.name.orEmpty(),
        originCountry = this.origin_country.orEmpty()
    )
}

fun TvDetailsProductionCountryDTO.toDomain(): TvDetailsProductionCountry {
    return TvDetailsProductionCountry(
        countryCode = this.countryCode.orEmpty(),
        name = this.name.orEmpty()
    )
}

fun TvDetailsSeasonDTO.toDomain(): TvDetailsSeason {
    return TvDetailsSeason(
        airDate = this.air_date.orEmpty(),
        episodeCount = this.episode_count.orZero(),
        id = this.id.orZero(),
        name = this.name.orEmpty(),
        overview = this.overview.orEmpty(),
        posterPath = generateImagePath(this.poster_path),
        seasonNumber = this.season_number.orZero(),
        voteAverage = this.vote_average.orZero()
    )
}

fun TvDetailsSpokenLanguageDTO.toDomain(): TvDetailsSpokenLanguage {
    return TvDetailsSpokenLanguage(
        englishName = this.english_name.orEmpty(),
        languageCode = this.languageCode.orEmpty(),
        name = this.name.orEmpty()
    )
}