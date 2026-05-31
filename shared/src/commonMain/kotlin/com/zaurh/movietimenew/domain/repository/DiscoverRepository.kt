package com.zaurh.movietimenew.domain.repository

import com.zaurh.movietimenew.domain.discover.discover_movies.DiscoverMovies
import com.zaurh.movietimenew.util.Result

interface DiscoverRepository {
    suspend fun discoverMovies(withGenres: Long, page: Int): Result<DiscoverMovies>
}