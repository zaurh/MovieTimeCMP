package com.zaurh.movietimenew.domain.repository

import com.zaurh.movietimenew.domain.models.person.person_details.PersonDetails
import com.zaurh.movietimenew.domain.models.person.person_image.PersonImages
import com.zaurh.movietimenew.domain.models.person.person_movies.PersonMovies
import com.zaurh.movietimenew.domain.models.person.person_popular.PersonPopular
import com.zaurh.movietimenew.domain.models.person.person_social_media.PersonSocialMedia
import com.zaurh.movietimenew.domain.models.person.person_tv.PersonTv
import com.zaurh.movietimenew.util.Result

interface PeopleRepository {
    suspend fun getPerson(personId: Long): Result<PersonDetails>
    suspend fun getPersonMovies(personId: Long): Result<PersonMovies>
    suspend fun getPersonTvShows(personId: Long): Result<PersonTv>
    suspend fun getPersonSocialMedia(personId: Long): Result<PersonSocialMedia>
    suspend fun getPersonImages(personId: Long): Result<PersonImages>
    suspend fun getPersonPopular(page: Int): Result<PersonPopular>
}