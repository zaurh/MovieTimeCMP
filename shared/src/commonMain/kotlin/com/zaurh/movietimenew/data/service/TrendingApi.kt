package com.zaurh.movietimenew.data.service

import com.zaurh.movietimenew.data.models.trending.all.TrendingAllDTO
import com.zaurh.movietimenew.data.models.trending.movie.TrendingMoviesDTO
import com.zaurh.movietimenew.data.models.trending.person.TrendingPeopleDTO
import com.zaurh.movietimenew.data.models.trending.tv.TrendingTvDTO
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class TrendingApi(
    private val httpClient: HttpClient
) {

    suspend fun getTrendingAll(
        timeWindow: String = "week",
        language: String
    ): TrendingAllDTO {
        return httpClient.get("trending/all/$timeWindow") {
            parameter("language", language)
        }.body()
    }

    suspend fun getTrendingMovies(
        timeWindow: String = "week",
        language: String
    ): TrendingMoviesDTO {
        return httpClient.get("trending/movie/$timeWindow") {
            parameter("language", language)
        }.body()
    }

    suspend fun getTrendingPeople(
        timeWindow: String = "week",
        language: String
    ): TrendingPeopleDTO {
        return httpClient.get("trending/person/$timeWindow") {
            parameter("language", language)
        }.body()
    }

    suspend fun getTrendingTv(
        timeWindow: String = "week",
        language: String
    ): TrendingTvDTO {
        return httpClient.get("trending/tv/$timeWindow") {
            parameter("language", language)
        }.body()
    }
}