package com.zaurh.movietimenew.data.repository

import com.zaurh.movietimenew.data.mapper.discover.toDomain
import com.zaurh.movietimenew.data.service.DiscoverApi
import com.zaurh.movietimenew.domain.discover.discover_movies.DiscoverMovies
import com.zaurh.movietimenew.domain.repository.DiscoverRepository
import com.zaurh.movietimenew.util.Result

class DiscoverRepoImpl(
    private val api: DiscoverApi
) : DiscoverRepository {

    override suspend fun discoverMovies(withGenres: Long, page: Int): Result<DiscoverMovies> {
        return try {
            val discoverMovies = api.discoverMovies(
                withGenres = withGenres,
                page = page,
                language = "en"
            )
            Result.Success(discoverMovies.toDomain())
        } catch (e: Exception) {
            Result.Error(message = e.message.toString())
        }
    }
}