package com.zaurh.movietimenew.data.repository

import com.zaurh.movietimenew.data.mapper.trending.toDomain
import com.zaurh.movietimenew.data.service.TrendingApi
import com.zaurh.movietimenew.domain.models.trending.all.TrendingAll
import com.zaurh.movietimenew.domain.models.trending.movie.TrendingMovies
import com.zaurh.movietimenew.domain.models.trending.person.TrendingPeople
import com.zaurh.movietimenew.domain.models.trending.tv.TrendingTv
import com.zaurh.movietimenew.domain.repository.TrendingRepository
import com.zaurh.movietimenew.util.Result

class TrendingRepoImpl(
    private val api: TrendingApi,
) : TrendingRepository {

    override suspend fun getTrendingAll(): Result<TrendingAll> {
        return try {
            val trendingAll = api.getTrendingAll(language = "en")
            Result.Success(trendingAll.toDomain())
        } catch (e: Exception) {
            Result.Error(message = e.message.toString())
        }
    }

    override suspend fun getTrendingMovies(): Result<TrendingMovies> {
        return try {
            val trendingMovies = api.getTrendingMovies(language = "en")
            Result.Success(trendingMovies.toDomain())
        } catch (e: Exception) {
            Result.Error(message = e.message.toString())
        }
    }

    override suspend fun getTrendingPeople(): Result<TrendingPeople> {
        return try {
            val trendingPeople = api.getTrendingPeople(language = "en")
            Result.Success(trendingPeople.toDomain())
        } catch (e: Exception) {
            Result.Error(message = e.message.toString())
        }
    }

    override suspend fun getTrendingTv(): Result<TrendingTv> {
        return try {
            val trendingTv = api.getTrendingTv(language = "en")
            Result.Success(trendingTv.toDomain())
        } catch (e: Exception) {
            Result.Error(message = e.message.toString())
        }
    }
}