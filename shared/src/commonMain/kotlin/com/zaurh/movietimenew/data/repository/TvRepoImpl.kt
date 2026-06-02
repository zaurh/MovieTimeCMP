package com.zaurh.movietimenew.data.repository

import com.zaurh.movietimenew.data.mapper.tv.toDomain
import com.zaurh.movietimenew.data.service.TvApi
import com.zaurh.movietimenew.domain.models.tv.tv_credits.TvCredits
import com.zaurh.movietimenew.domain.models.tv.tv_details.TvDetails
import com.zaurh.movietimenew.domain.models.tv.tv_image.TvImages
import com.zaurh.movietimenew.domain.models.tv.tv_similar.TvSimilar
import com.zaurh.movietimenew.domain.models.tv.tv_video.TvVideos
import com.zaurh.movietimenew.domain.models.tv.tv_watch_providers.TvWatchProviders
import com.zaurh.movietimenew.domain.repository.TvRepository
import com.zaurh.movietimenew.util.Result

class TvRepoImpl(
    private val api: TvApi,
) : TvRepository {
    override suspend fun getTvDetails(seriesId: Long): Result<TvDetails> {
        return try {
            val tvDetails = api.getTvDetails(seriesId, "en")
            Result.Success(tvDetails.toDomain())
        } catch (e: Exception) {
            Result.Error(message = e.message.toString())
        }
    }

    override suspend fun getTvImages(seriesId: Long): Result<TvImages> {
        return try {
            val tvImages = api.getTvImages(seriesId)
            Result.Success(tvImages.toDomain())
        } catch (e: Exception) {
            Result.Error(message = e.message.toString())
        }
    }

    override suspend fun getTvDetailsVideo(seriesId: Long): Result<TvVideos> {
        return try {
            val tvDetailsVideo = api.getTvDetailsVideo(seriesId, "en")

            if (tvDetailsVideo.results?.isEmpty() == true) {
                val tvDetailsVideoEnglish = api.getTvDetailsVideo(seriesId, "en")
                Result.Success(tvDetailsVideoEnglish.toDomain())
            } else {
                Result.Success(tvDetailsVideo.toDomain())
            }
        } catch (e: Exception) {
            Result.Error(message = e.message.toString())
        }
    }

    override suspend fun getTvSimilar(seriesId: Long): Result<TvSimilar> {
        return try {
            val tvSimilar = api.getTvSimilar(seriesId, "en")
            Result.Success(tvSimilar.toDomain())
        } catch (e: Exception) {
            Result.Error(message = e.message.toString())
        }
    }

    override suspend fun getTvWatchProviders(seriesId: Long): Result<TvWatchProviders> {
        return try {
            val watchProviders = api.getTvWatchProviders(seriesId).toDomain()
            Result.Success(watchProviders)
        } catch (e: Exception) {
            Result.Error(message = e.message.toString())
        }
    }

    override suspend fun getTvCredits(seriesId: Long, language: String): Result<TvCredits> {
        return try {
            val credits = api.getTvCredits(seriesId, language).toDomain()
            Result.Success(credits)
        } catch (e: Exception) {
            Result.Error(message = e.message.toString())
        }
    }
}