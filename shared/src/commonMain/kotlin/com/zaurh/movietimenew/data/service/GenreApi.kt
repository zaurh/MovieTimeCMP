package com.zaurh.movietimenew.data.service

import com.zaurh.movietimenew.data.models.genres.GenresDTO
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class GenreApi(private val client: HttpClient) {
    suspend fun getGenres(language: String): GenresDTO {
        return client.get("genre/movie/list") {
            parameter("language", language)
        }.body()
    }
}