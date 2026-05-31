package com.zaurh.movietimenew.data.service

import com.zaurh.movietimenew.data.models.movie.movie_credits.MovieCreditsDTO
import com.zaurh.movietimenew.data.models.movie.movie_details.MovieDetailsDTO
import com.zaurh.movietimenew.data.models.movie.movie_image.MovieImagesDTO
import com.zaurh.movietimenew.data.models.movie.movie_recommendations.MovieRecommendationsDTO
import com.zaurh.movietimenew.data.models.movie.movie_video.MovieVideoDTO
import com.zaurh.movietimenew.data.models.movie.movie_now_playing.NowPlayingMoviesDTO
import com.zaurh.movietimenew.data.models.movie.movie_popular.PopularMoviesDTO
import com.zaurh.movietimenew.data.models.movie.movie_top_rated.TopRatedMoviesDTO
import com.zaurh.movietimenew.data.models.movie.movie_upcoming.UpcomingMoviesDTO
import com.zaurh.movietimenew.data.models.movie.movie_watch_providers.MovieWatchProvidersDTO
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class MovieApi(private val client: HttpClient) {

    suspend fun getUpcomingMovies(language: String): UpcomingMoviesDTO {
        return client.get("movie/upcoming") {
            parameter("language", language)
        }.body()
    }

    suspend fun getPopularMovies(language: String): PopularMoviesDTO {
        return client.get("movie/popular") {
            parameter("language", language)
        }.body()
    }

    suspend fun getNowPlayingMovies(language: String): NowPlayingMoviesDTO {
        return client.get("movie/now_playing") {
            parameter("language", language)
        }.body()
    }

    suspend fun getTopRatedMovies(language: String): TopRatedMoviesDTO {
        return client.get("movie/top_rated") {
            parameter("language", language)
        }.body()
    }

    suspend fun getMovieDetails(movieId: Long, language: String): MovieDetailsDTO {
        return client.get("movie/$movieId") {
            parameter("language", language)
        }.body()
    }

    suspend fun getMovieImages(movieId: Long): MovieImagesDTO {
        return client.get("movie/$movieId/images").body()
    }

    suspend fun getMovieVideos(movieId: Long, language: String): MovieVideoDTO {
        return client.get("movie/$movieId/videos") {
            parameter("language", language)
        }.body()
    }

    suspend fun getRecommendations(movieId: Long, language: String): MovieRecommendationsDTO {
        return client.get("movie/$movieId/recommendations") {
            parameter("language", language)
        }.body()
    }

    suspend fun getMovieCredits(movieId: Long, language: String): MovieCreditsDTO {
        return client.get("movie/$movieId/credits") {
            parameter("language", language)
        }.body()
    }

    suspend fun getMovieWatchProviders(movieId: Long): MovieWatchProvidersDTO {
        return client.get("movie/$movieId/watch/providers").body()
    }
}