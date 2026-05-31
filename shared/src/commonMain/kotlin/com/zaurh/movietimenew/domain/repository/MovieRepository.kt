package com.zaurh.movietimenew.domain.repository

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
import com.zaurh.movietimenew.util.Result

interface MovieRepository {
    suspend fun getMovieImages(movieId: Long): Result<MovieImages>
    suspend fun getMovieVideo(movieId: Long): Result<MovieVideo>
    suspend fun getUpcomingMovies(): Result<UpcomingMovies>
    suspend fun getPopularMovies(): Result<PopularMovies>
    suspend fun getNowPlayingMovies(): Result<NowPlayingMovies>
    suspend fun getTopRatedMovies(): Result<TopRatedMovies>
    suspend fun getMovieDetails(movieId: Long): Result<MovieDetails>
    suspend fun getRecommendations(movieId: Long): Result<MovieRecommendations>
    suspend fun getCredits(movieId: Long, language: String): Result<MovieCredits>
    suspend fun getMovieWatchProviders(movieId: Long): Result<MovieWatchProviders>
}