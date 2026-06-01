package com.zaurh.movietimenew.data.service

import com.zaurh.movietimenew.data.models.person.PersonDetailsDTO
import com.zaurh.movietimenew.data.models.person.PersonMoviesDTO
import com.zaurh.movietimenew.data.models.person.PersonSocialMediaDTO
import com.zaurh.movietimenew.data.models.person.person_image.PersonImagesDTO
import com.zaurh.movietimenew.data.models.person.person_popular.PersonPopularDTO
import com.zaurh.movietimenew.data.models.person.person_tv.PersonTvDTO
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class PersonApi(
    private val httpClient: HttpClient
) {
    suspend fun getPerson(
        personId: Long,
        language: String
    ): PersonDetailsDTO {
        return httpClient.get("person/$personId") {
            parameter("language", language)
        }.body()
    }

    suspend fun getPersonMovies(
        personId: Long,
        language: String
    ): PersonMoviesDTO {
        return httpClient.get("person/$personId/movie_credits") {
            parameter("language", language)
        }.body()
    }

    suspend fun getPersonTvShows(
        personId: Long,
        language: String
    ): PersonTvDTO {
        return httpClient.get("person/$personId/tv_credits") {
            parameter("language", language)
        }.body()
    }

    suspend fun getPersonSocialMedia(
        personId: Long
    ): PersonSocialMediaDTO {
        return httpClient.get("person/$personId/external_ids")
            .body()
    }

    suspend fun getPersonImages(
        personId: Long
    ): PersonImagesDTO {
        return httpClient.get("person/$personId/images")
            .body()
    }

    suspend fun getPersonPopular(
        page: Int,
        language: String
    ): PersonPopularDTO {
        return httpClient.get("person/popular") {
            parameter("page", page)
            parameter("language", language)
        }.body()
    }
}