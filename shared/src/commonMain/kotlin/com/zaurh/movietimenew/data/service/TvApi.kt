package com.zaurh.movietimenew.data.service

import com.zaurh.movietimenew.data.models.tv.tv_credits.TvCreditsDTO
import com.zaurh.movietimenew.data.models.tv.tv_details.TvDetailsDTO
import com.zaurh.movietimenew.data.models.tv.tv_image.TvImagesDTO
import com.zaurh.movietimenew.data.models.tv.tv_similar.TvSimilarDTO
import com.zaurh.movietimenew.data.models.tv.tv_video.TvVideosDTO
import com.zaurh.movietimenew.data.models.tv.tv_watch_providers.TvWatchProvidersDTO
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class TvApi(
    private val httpClient: HttpClient
) {

    suspend fun getTvDetails(
        seriesId: Long,
        language: String
    ): TvDetailsDTO {
        return httpClient.get("tv/$seriesId") {
            parameter("language", language)
        }.body()
    }

    suspend fun getTvImages(
        seriesId: Long
    ): TvImagesDTO {
        return httpClient.get("tv/$seriesId/images")
            .body()
    }

    suspend fun getTvDetailsVideo(
        seriesId: Long,
        language: String
    ): TvVideosDTO {
        return httpClient.get("tv/$seriesId/videos") {
            parameter("language", language)
        }.body()
    }

    suspend fun getTvSimilar(
        seriesId: Long,
        language: String
    ): TvSimilarDTO {
        return httpClient.get("tv/$seriesId/similar") {
            parameter("language", language)
        }.body()
    }

    suspend fun getTvWatchProviders(
        seriesId: Long
    ): TvWatchProvidersDTO {
        return httpClient.get("tv/$seriesId/watch/providers")
            .body()
    }

    suspend fun getTvCredits(
        seriesId: Long,
        language: String
    ): TvCreditsDTO {
        return httpClient.get("tv/$seriesId/credits") {
            parameter("language", language)
        }.body()
    }
}