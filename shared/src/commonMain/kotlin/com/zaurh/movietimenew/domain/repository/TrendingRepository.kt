package com.zaurh.movietimenew.domain.repository

import com.zaurh.movietimenew.domain.models.trending.all.TrendingAll
import com.zaurh.movietimenew.domain.models.trending.movie.TrendingMovies
import com.zaurh.movietimenew.domain.models.trending.person.TrendingPeople
import com.zaurh.movietimenew.domain.models.trending.tv.TrendingTv
import com.zaurh.movietimenew.util.Result

interface TrendingRepository {
    suspend fun getTrendingAll(): Result<TrendingAll>
    suspend fun getTrendingMovies(): Result<TrendingMovies>
    suspend fun getTrendingPeople(): Result<TrendingPeople>
    suspend fun getTrendingTv(): Result<TrendingTv>
}