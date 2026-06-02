package com.zaurh.movietimenew.data.mapper.tv

import com.zaurh.movietimenew.data.models.tv.tv_credits.TvCreditsCastDTO
import com.zaurh.movietimenew.data.models.tv.tv_credits.TvCreditsCrewDTO
import com.zaurh.movietimenew.data.models.tv.tv_credits.TvCreditsDTO
import com.zaurh.movietimenew.domain.models.tv.tv_credits.TvCredits
import com.zaurh.movietimenew.domain.models.tv.tv_credits.TvCreditsCast
import com.zaurh.movietimenew.domain.models.tv.tv_credits.TvCreditsCrew
import com.zaurh.movietimenew.util.generateImagePath
import com.zaurh.movietimenew.util.orFalse
import com.zaurh.movietimenew.util.orZero

fun TvCreditsDTO.toDomain(): TvCredits {
    return TvCredits(
        cast = this.cast?.map { it.toDomain() }.orEmpty(),
        crew = this.crew?.map { it.toDomain() }.orEmpty(),
        id = this.id.orZero()
    )
}

fun TvCreditsCastDTO.toDomain(): TvCreditsCast {
    return TvCreditsCast(
        adult = this.adult.orFalse(),
        gender = this.gender.orZero(),
        id = this.id.orZero(),
        knownForDepartment = this.known_for_department.orEmpty(),
        name = this.name.orEmpty(),
        originalName = this.original_name.orEmpty(),
        popularity = this.popularity.orZero(),
        profilePath = generateImagePath(this.profile_path),
        character = this.character.orEmpty(),
        creditId = this.credit_id.orEmpty(),
        order = this.order.orZero()
    )
}

fun TvCreditsCrewDTO.toDomain(): TvCreditsCrew {
    return TvCreditsCrew(
        adult = this.adult.orFalse(),
        gender = this.gender.orZero(),
        id = this.id.orZero(),
        knownForDepartment = this.known_for_department.orEmpty(),
        name = this.name.orEmpty(),
        originalName = this.original_name.orEmpty(),
        popularity = this.popularity.orZero(),
        profilePath = generateImagePath(this.profile_path),
        creditId = this.credit_id.orEmpty(),
        department = this.department.orEmpty(),
        job = this.job.orEmpty()
    )
}