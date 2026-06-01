package com.zaurh.movietimenew.data.service

import com.zaurh.movietimenew.data.models.search.person.SearchPersonDTO
import com.zaurh.movietimenew.data.models.search.tv.SearchTvDTO
import com.zaurh.movietimenew.data.models.search.movies.SearchMoviesDTO
import com.zaurh.movietimenew.data.models.search.multi.SearchMultiDTO
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class SearchApi(private val client: HttpClient) {

    suspend fun searchMovies(
        query: String,
        page: Int = 1,
        language: String
    ): SearchMoviesDTO {
        return client.get("search/movie") {
            parameter("query", query)
            parameter("page", page)
            parameter("language", language)
        }.body()
    }

    suspend fun searchPerson(
        query: String,
        page: Int = 1,
        language: String
    ): SearchPersonDTO {
        return client.get("search/person") {
            parameter("query", query)
            parameter("page", page)
            parameter("language", language)
        }.body()
    }

    suspend fun searchMulti(
        query: String,
        page: Int = 1,
        language: String
    ): SearchMultiDTO {
        return client.get("search/multi") {
            parameter("query", query)
            parameter("page", page)
            parameter("language", language)
        }.body()
    }

    suspend fun searchTv(
        query: String,
        page: Int = 1,
        language: String
    ): SearchTvDTO {
        return client.get("search/tv") {
            parameter("query", query)
            parameter("page", page)
            parameter("language", language)
        }.body()
    }
}