package com.zaurh.movietimenew.data.repository

import com.zaurh.movieappintern2.data.mapper.movie.toDomain
import com.zaurh.movietimenew.data.mapper.movie.toDomain
import com.zaurh.movietimenew.data.service.MovieApi
import com.zaurh.movietimenew.domain.models.movie.movie_credits.MovieCredits
import com.zaurh.movietimenew.domain.models.movie.movie_details.MovieDetails
import com.zaurh.movietimenew.domain.models.movie.movie_image.MovieImages
import com.zaurh.movietimenew.domain.models.movie.movie_now_playing.NowPlayingMovies
import com.zaurh.movietimenew.domain.models.movie.movie_popular.PopularMovies
import com.zaurh.movietimenew.domain.models.movie.movie_recommendations.MovieRecommendations
import com.zaurh.movietimenew.domain.models.movie.movie_top_rated.TopRatedMovies
import com.zaurh.movietimenew.domain.models.movie.movie_upcoming.UpcomingMovies
import com.zaurh.movietimenew.domain.models.movie.movie_video.MovieVideo
import com.zaurh.movietimenew.domain.models.movie.movie_watch_providers.MovieWatchProviders
import com.zaurh.movietimenew.domain.repository.MovieRepository
import com.zaurh.movietimenew.util.Result

class MovieRepoImpl(
    private val api: MovieApi
) : MovieRepository {

    override suspend fun getMovieImages(movieId: Long): Result<MovieImages> {
        return try {
            val movieImages = api.getMovieImages(movieId = movieId)
            Result.Success(movieImages.toDomain())
        } catch (e: Exception) {
            Result.Error(message = e.message.toString())
        }
    }

    override suspend fun getMovieVideo(movieId: Long): Result<MovieVideo> {
        return try {
            val movieVideo = api.getMovieVideos(movieId = movieId, language = "en")

            if (movieVideo.results?.isEmpty() == true) {
                val movieVideoEnglish = api.getMovieVideos(movieId = movieId, language = "en")
                Result.Success(movieVideoEnglish.toDomain())
            } else {
                Result.Success(movieVideo.toDomain())
            }
        } catch (e: Exception) {
            Result.Error(message = e.message.toString())
        }
    }

    override suspend fun getUpcomingMovies(): Result<UpcomingMovies> {
        return try {
            val upcomingMovies = api.getUpcomingMovies("en")
            Result.Success(upcomingMovies.toDomain())
        } catch (e: Exception) {
            Result.Error(message = e.message.toString())
        }
    }

    override suspend fun getPopularMovies(): Result<PopularMovies> {
        return try {
            val popularMovies = api.getPopularMovies("en")
            Result.Success(popularMovies.toDomain())

        } catch (e: Exception) {
            Result.Error(message = e.message.toString())
        }
    }

    override suspend fun getNowPlayingMovies(): Result<NowPlayingMovies> {
        return try {
            val nowPlayingMovies = api.getNowPlayingMovies("en")
            Result.Success(nowPlayingMovies.toDomain())
        } catch (e: Exception) {
            Result.Error(message = e.message.toString())
        }
    }

    override suspend fun getTopRatedMovies(): Result<TopRatedMovies> {
        return try {
            val topRatedMovies = api.getTopRatedMovies("en")
            Result.Success(topRatedMovies.toDomain())
        } catch (e: Exception) {
            Result.Error(message = e.message.toString())
        }
    }

    override suspend fun getMovieDetails(movieId: Long): Result<MovieDetails> {
        return try {
            val movieDetails = api.getMovieDetails(movieId = movieId, language = "en")
            Result.Success(movieDetails.toDomain())
        } catch (e: Exception) {
            Result.Error(message = e.message.toString())
        }
    }

    override suspend fun getRecommendations(movieId: Long): Result<MovieRecommendations> {
        return try {
            val recommendedMovies =
                api.getRecommendations(movieId = movieId, language = "en")
            Result.Success(recommendedMovies.toDomain())

        } catch (e: Exception) {
            Result.Error(message = e.message.toString())
        }
    }

    override suspend fun getCredits(movieId: Long, language: String): Result<MovieCredits> {
        return try {
            val credits = api.getMovieCredits(movieId, language).toDomain()
            Result.Success(credits)
        } catch (e: Exception) {
            Result.Error(message = e.message.toString())
        }
    }

    override suspend fun getMovieWatchProviders(movieId: Long): Result<MovieWatchProviders> {
        return try {
            val watchProviders = api.getMovieWatchProviders(movieId).toDomain()
            Result.Success(watchProviders)
        } catch (e: Exception) {
            Result.Error(message = e.message.toString())
        }
    }
}