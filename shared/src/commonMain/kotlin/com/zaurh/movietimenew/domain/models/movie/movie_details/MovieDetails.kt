package com.zaurh.movietimenew.domain.models.movie.movie_details

import com.zaurh.movietimenew.util.EMPTY
import com.zaurh.movietimenew.util.ZERO
import com.zaurh.movietimenew.util.ZERO_DOUBLE
import com.zaurh.movietimenew.util.ZERO_LONG

data class MovieDetails(
    val adult: Boolean = false,
    val backdropPath: String = EMPTY,
    val belongsToCollection: MovieDetailsBelongsToCollection = MovieDetailsBelongsToCollection(),
    val budget: Long = ZERO_LONG,
    val genres: List<MovieDetailsGenre> = listOf(),
    val homepage: String = EMPTY,
    val id: Long = ZERO_LONG,
    val imdbId: String = EMPTY,
    val originCountry: List<String> = listOf(),
    val originalLanguage: String = EMPTY,
    val originalTitle: String = EMPTY,
    val overview: String = EMPTY,
    val popularity: Double = ZERO_DOUBLE,
    val poster: String = EMPTY,
    val productionCompanies: List<MovieDetailsProductionCompany> = listOf(),
    val productionCountries: List<MovieDetailsProductionCountry> = listOf(),
    val releaseDate: String = EMPTY,
    val revenue: Long = ZERO_LONG,
    val runtime: Int = ZERO,
    val spokenLanguages: List<MovieDetailsSpokenLanguage> = listOf(),
    val status: String = EMPTY,
    val tagline: String = EMPTY,
    val title: String = EMPTY,
    val video: Boolean = false,
    val voteAverage: Double = ZERO_DOUBLE,
    val voteCount: Int = ZERO
)
