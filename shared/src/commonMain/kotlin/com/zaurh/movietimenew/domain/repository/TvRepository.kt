package com.zaurh.movietimenew.domain.repository

import com.zaurh.movietimenew.domain.models.tv.tv_credits.TvCredits
import com.zaurh.movietimenew.domain.models.tv.tv_details.TvDetails
import com.zaurh.movietimenew.domain.models.tv.tv_image.TvImages
import com.zaurh.movietimenew.domain.models.tv.tv_similar.TvSimilar
import com.zaurh.movietimenew.domain.models.tv.tv_video.TvVideos
import com.zaurh.movietimenew.domain.models.tv.tv_watch_providers.TvWatchProviders
import com.zaurh.movietimenew.util.Result

interface TvRepository {
    suspend fun getTvDetails(seriesId: Long): Result<TvDetails>
    suspend fun getTvImages(seriesId: Long): Result<TvImages>
    suspend fun getTvDetailsVideo(seriesId: Long): Result<TvVideos>
    suspend fun getTvSimilar(seriesId: Long): Result<TvSimilar>
    suspend fun getTvWatchProviders(seriesId: Long): Result<TvWatchProviders>
    suspend fun getTvCredits(seriesId: Long, language: String): Result<TvCredits>
}