package com.zaurh.movietimenew.data.repository

import com.zaurh.movietimenew.data.mapper.search.toDomain
import com.zaurh.movietimenew.data.service.SearchApi
import com.zaurh.movietimenew.domain.models.search.movies.SearchMovies
import com.zaurh.movietimenew.domain.models.search.multi.SearchMulti
import com.zaurh.movietimenew.domain.models.search.person.SearchPerson
import com.zaurh.movietimenew.domain.models.search.tv.SearchTv
import com.zaurh.movietimenew.domain.repository.SearchRepository
import com.zaurh.movietimenew.util.Result

class SearchRepoImpl (
    private val api: SearchApi,
) : SearchRepository {

    override suspend fun searchMovies(query: String, page: Int): Result<SearchMovies> {
        return try {
            val searchMovies = api.searchMovies(query = query, page = page, language = "en")
            Result.Success(searchMovies.toDomain())
        } catch (e: Exception) {
            Result.Error(message = e.message.toString())
        }
    }

    override suspend fun searchPerson(
        query: String,
        page: Int
    ): Result<SearchPerson> {
        return try {
            val searchPerson = api.searchPerson(query = query, page = page, language = "en")
            Result.Success(searchPerson.toDomain())
        } catch (e: Exception) {
            Result.Error(message = e.message.toString())
        }
    }

    override suspend fun searchMulti(
        query: String,
        page: Int
    ): Result<SearchMulti> {
        return try {
            val searchMulti = api.searchMulti(query = query, page = page, language = "en")
            Result.Success(searchMulti.toDomain())
        } catch (e: Exception) {
            Result.Error(message = e.message.toString())
        }
    }

    override suspend fun searchTv(
        query: String,
        page: Int
    ): Result<SearchTv> {
        return try {
            val searchTv = api.searchTv(query = query, page = page, language = "en")
            Result.Success(searchTv.toDomain())
        } catch (e: Exception) {
            Result.Error(message = e.message.toString())
        }
    }
}