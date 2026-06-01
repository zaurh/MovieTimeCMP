package com.zaurh.movietimenew.data.repository

import com.zaurh.movietimenew.data.mapper.person.toDomain
import com.zaurh.movietimenew.data.service.PersonApi
import com.zaurh.movietimenew.domain.models.person.person_details.PersonDetails
import com.zaurh.movietimenew.domain.models.person.person_image.PersonImages
import com.zaurh.movietimenew.domain.models.person.person_movies.PersonMovies
import com.zaurh.movietimenew.domain.models.person.person_popular.PersonPopular
import com.zaurh.movietimenew.domain.models.person.person_social_media.PersonSocialMedia
import com.zaurh.movietimenew.domain.models.person.person_tv.PersonTv
import com.zaurh.movietimenew.domain.repository.PeopleRepository
import com.zaurh.movietimenew.util.Result

class PeopleRepoImpl (
    private val api: PersonApi,
) : PeopleRepository {

    override suspend fun getPerson(personId: Long): Result<PersonDetails> {
        return try {
            val credits = api.getPerson(personId, "en").toDomain()
            Result.Success(credits)
        } catch (e: Exception) {
            Result.Error(message = e.message.toString())
        }
    }

    override suspend fun getPersonMovies(personId: Long): Result<PersonMovies> {
        return try {
            val movies = api.getPersonMovies(personId, "en").toDomain()
            Result.Success(movies)
        } catch (e: Exception) {
            Result.Error(message = e.message.toString())
        }
    }

    override suspend fun getPersonTvShows(personId: Long): Result<PersonTv> {
        return try {
            val movies = api.getPersonTvShows(personId, "en").toDomain()
            Result.Success(movies)
        } catch (e: Exception) {
            Result.Error(message = e.message.toString())
        }
    }

    override suspend fun getPersonSocialMedia(personId: Long): Result<PersonSocialMedia> {
        return try {
            val socialMediaList = api.getPersonSocialMedia(personId).toDomain()
            Result.Success(socialMediaList)
        } catch (e: Exception) {
            Result.Error(message = e.message.toString())
        }
    }

    override suspend fun getPersonImages(personId: Long): Result<PersonImages> {
        return try {
            val personImages = api.getPersonImages(personId).toDomain()
            Result.Success(personImages)
        } catch (e: Exception) {
            Result.Error(message = e.message.toString())
        }
    }

    override suspend fun getPersonPopular(page: Int): Result<PersonPopular> {
        return try {
            val personPopular = api.getPersonPopular(page, "en").toDomain()
            Result.Success(personPopular)
        } catch (e: Exception) {
            Result.Error(message = e.message.toString())
        }
    }
}