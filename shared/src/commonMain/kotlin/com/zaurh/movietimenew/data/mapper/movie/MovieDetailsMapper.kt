package com.zaurh.movietimenew.data.mapper.movie

import com.zaurh.movietimenew.data.models.movie.movie_details.MovieDetailsBelongsToCollectionDTO
import com.zaurh.movietimenew.data.models.movie.movie_details.MovieDetailsDTO
import com.zaurh.movietimenew.data.models.movie.movie_details.MovieDetailsGenreDTO
import com.zaurh.movietimenew.data.models.movie.movie_details.MovieDetailsProductionCompanyDTO
import com.zaurh.movietimenew.data.models.movie.movie_details.MovieDetailsProductionCountryDTO
import com.zaurh.movietimenew.data.models.movie.movie_details.MovieDetailsSpokenLanguageDTO
import com.zaurh.movietimenew.domain.models.movie.movie_details.MovieDetails
import com.zaurh.movietimenew.domain.models.movie.movie_details.MovieDetailsBelongsToCollection
import com.zaurh.movietimenew.domain.models.movie.movie_details.MovieDetailsGenre
import com.zaurh.movietimenew.domain.models.movie.movie_details.MovieDetailsProductionCompany
import com.zaurh.movietimenew.domain.models.movie.movie_details.MovieDetailsProductionCountry
import com.zaurh.movietimenew.domain.models.movie.movie_details.MovieDetailsSpokenLanguage
import com.zaurh.movietimenew.util.generateImagePath
import com.zaurh.movietimenew.util.orFalse
import com.zaurh.movietimenew.util.orZero

fun MovieDetailsDTO.toDomain(): MovieDetails {
    return MovieDetails(
        adult = this.adult.orFalse(),
        backdropPath = this.backdrop_path.orEmpty(),
        belongsToCollection = this.belongs_to_collection.toDomain(),
        budget = this.budget.orZero(),
        genres = this.genres?.map { it.toDomain() }.orEmpty(),
        homepage = this.homepage.orEmpty(),
        id = this.id.orZero(),
        imdbId = this.imdb_id.orEmpty(),
        originCountry = this.origin_country.orEmpty(),
        originalLanguage = this.original_language.orEmpty(),
        originalTitle = this.original_title.orEmpty(),
        overview = this.overview.orEmpty(),
        popularity = this.popularity.orZero(),
        poster = generateImagePath(this.poster_path),
        productionCompanies = this.production_companies?.map { it.toDomain() }.orEmpty(),
        productionCountries = this.production_countries?.map { it.toDomain() }.orEmpty(),
        releaseDate = this.release_date.orEmpty(),
        revenue = this.revenue.orZero(),
        runtime = this.runtime.orZero(),
        spokenLanguages = this.spoken_languages?.map { it.toDomain() }.orEmpty(),
        status = this.status.orEmpty(),
        tagline = this.tagline.orEmpty(),
        title = this.title.orEmpty(),
        video = this.video.orFalse(),
        voteAverage = this.vote_average.orZero(),
        voteCount = this.vote_count.orZero()
    )
}

fun MovieDetailsGenreDTO.toDomain(): MovieDetailsGenre {
    return MovieDetailsGenre(
        id = this.id.orZero(),
        name = this.name.orEmpty()
    )
}

fun MovieDetailsSpokenLanguageDTO.toDomain(): MovieDetailsSpokenLanguage {
    return MovieDetailsSpokenLanguage(
        englishName = this.english_name.orEmpty(),
        languageCode = this.languageCode.orEmpty(),
        name = this.name.orEmpty()
    )
}

fun MovieDetailsBelongsToCollectionDTO?.toDomain(): MovieDetailsBelongsToCollection {
    return MovieDetailsBelongsToCollection(
        id = this?.id.orZero(),
        name = this?.name.orEmpty(),
        posterPath = generateImagePath(this?.poster_path),
        backdropPath = generateImagePath(this?.backdrop_path)
    )
}

fun MovieDetailsProductionCompanyDTO.toDomain(): MovieDetailsProductionCompany {
    return MovieDetailsProductionCompany(
        id = this.id.orZero(),
        logoPath = generateImagePath(this.logo_path),
        name = this.name.orEmpty(),
        originCountry = this.origin_country.orEmpty()
    )
}

fun MovieDetailsProductionCountryDTO.toDomain(): MovieDetailsProductionCountry {
    return MovieDetailsProductionCountry(
        countryCode = this.countryCode.orEmpty(),
        name = this.name.orEmpty()
    )
}