package com.zaurh.movietimenew.data.service

import com.zaurh.movietimenew.data.models.discover.discover_movie.DiscoverMoviesDTO
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class DiscoverApi(private val client: HttpClient) {
    suspend fun discoverMovies(
        withGenres: Long,
        page: Int = 1,
        language: String
    ): DiscoverMoviesDTO {

        return client.get("discover/movie") {
            parameter("with_genres", withGenres)
            parameter("page", page)
            parameter("language", language)
        }.body()
    }
}