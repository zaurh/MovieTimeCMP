package com.zaurh.movietimenew.presentation.main

import com.zaurh.movietimenew.domain.models.genres.GenresItem
import com.zaurh.movietimenew.domain.models.movie.movie_now_playing.NowPlayingMoviesItem
import com.zaurh.movietimenew.domain.models.movie.movie_popular.PopularMoviesItem
import com.zaurh.movietimenew.domain.models.movie.movie_top_rated.TopRatedMoviesItem
import com.zaurh.movietimenew.domain.models.movie.movie_upcoming.UpcomingMoviesItem

data class MainUIState(
    val isLoading: Boolean = false,
    val genres: List<GenresItem> = emptyList(),
    val popularMovies: List<PopularMoviesItem> = emptyList(),
    val upcomingMovies: List<UpcomingMoviesItem> = emptyList(),
    val nowPlayingMovies: List<NowPlayingMoviesItem> = emptyList(),
    val topRatedMovies: List<TopRatedMoviesItem> = emptyList(),
)

sealed interface MainEvent {
    data object OnInit: MainEvent
    data class OnMovieClicked(val movieId: Long): MainEvent
    data class OnGenreClicked(val genreName: String, val genreId: Long): MainEvent
}

sealed interface MainSideEffect {
    data class NavigateToDetailsScreen(val movieId: Long): MainSideEffect
    data class NavigateToDiscoverScreen(val genreName: String,val genreId: Long): MainSideEffect
}