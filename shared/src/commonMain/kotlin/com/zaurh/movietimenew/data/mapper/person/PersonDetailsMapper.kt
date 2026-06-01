package com.zaurh.movietimenew.data.mapper.person

import com.zaurh.movietimenew.data.models.person.PersonDetailsDTO
import com.zaurh.movietimenew.domain.models.person.person_details.PersonDetails
import com.zaurh.movietimenew.util.generateImagePath
import com.zaurh.movietimenew.util.orFalse
import com.zaurh.movietimenew.util.orZero

fun PersonDetailsDTO.toDomain(): PersonDetails {
    return PersonDetails(
        adult = this.adult.orFalse(),
        alsoKnownAs = this.also_known_as.orEmpty(),
        biography = this.biography.orEmpty(),
        birthday = this.birthday.orEmpty(),
        deathday = this.deathday.orEmpty(),
        gender = this.gender.orZero(),
        homepage = this.homepage.orEmpty(),
        id = this.id.orZero(),
        imdbId = this.imdb_id.orEmpty(),
        knownForDepartment = this.known_for_department.orEmpty(),
        name = this.name.orEmpty(),
        placeOfBirth = this.place_of_birth.orEmpty(),
        popularity = this.popularity.orZero(),
        profilePath = generateImagePath(this.profile_path),
    )
}