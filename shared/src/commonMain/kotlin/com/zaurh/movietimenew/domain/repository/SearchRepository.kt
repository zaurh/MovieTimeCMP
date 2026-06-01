package com.zaurh.movietimenew.domain.repository

import com.zaurh.movietimenew.domain.models.search.movies.SearchMovies
import com.zaurh.movietimenew.domain.models.search.multi.SearchMulti
import com.zaurh.movietimenew.domain.models.search.person.SearchPerson
import com.zaurh.movietimenew.domain.models.search.tv.SearchTv
import com.zaurh.movietimenew.util.Result

interface SearchRepository {
    suspend fun searchMovies(query: String, page: Int): Result<SearchMovies>
    suspend fun searchPerson(query: String, page: Int): Result<SearchPerson>
    suspend fun searchMulti(query: String, page: Int): Result<SearchMulti>
    suspend fun searchTv(query: String, page: Int): Result<SearchTv>
}