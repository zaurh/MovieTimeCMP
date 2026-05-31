package com.zaurh.movietimenew.presentation.discover.states

import com.zaurh.movietimenew.presentation.model.MovieUIModel
import com.zaurh.movietimenew.util.EMPTY
import com.zaurh.movietimenew.util.ZERO
import com.zaurh.movietimenew.util.ZERO_LONG

data class DiscoverUIState(
    val genreName: String = EMPTY,
    val genreId: Long = ZERO_LONG,
    val page: Int = 1,
    val totalPages: Int = ZERO,
    val totalResults: Int = ZERO,
    val isLoading: Boolean = false,
    val movies: List<MovieUIModel> = emptyList(),
    val errorMessage: String = EMPTY
)

sealed interface DiscoverEvent {
    data object OnInit : DiscoverEvent
    data object OnNavigateBack : DiscoverEvent
    data class OnMovieClicked(val movieId: Long) : DiscoverEvent
    data object OnPreviousPageClicked : DiscoverEvent
    data object OnNextPageClicked : DiscoverEvent
}

sealed interface DiscoverSideEffect {
    data class NavigateToDetailsScreen(val movieId: Long) : DiscoverSideEffect
    data object NavigateBack : DiscoverSideEffect
}