package com.zaurh.movieappintern2.data.mapper.movie

import com.zaurh.movietimenew.data.models.movie.movie_credits.MovieCreditsCastDTO
import com.zaurh.movietimenew.data.models.movie.movie_credits.MovieCreditsDTO
import com.zaurh.movietimenew.domain.models.movie.movie_credits.MovieCredits
import com.zaurh.movietimenew.domain.models.movie.movie_credits.MovieCreditsCast
import com.zaurh.movietimenew.util.generateImagePath
import com.zaurh.movietimenew.util.orFalse
import com.zaurh.movietimenew.util.orZero

fun MovieCreditsDTO.toDomain() =
    MovieCredits(
        id = this.id.orZero(),
        cast = this.cast?.map { it.toDomain() }.orEmpty()
    )

fun MovieCreditsCastDTO.toDomain(): MovieCreditsCast {
    return MovieCreditsCast(
        adult = this.adult.orFalse(),
        gender = this.gender.orZero(),
        id = this.id.orZero(),
        knownForDepartment = this.known_for_department.orEmpty(),
        name = this.name.orEmpty(),
        originalName = this.original_name.orEmpty(),
        popularity = this.popularity.orZero(),
        profilePath = generateImagePath(this.profile_path),
        castId = this.cast_id.orZero(),
        character = this.character.orEmpty(),
        creditId = this.credit_id.orEmpty(),
        order = this.order.orZero(),
    )
}