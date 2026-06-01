package com.zaurh.movietimenew.presentation.search

import com.zaurh.movietimenew.domain.models.search.multi.SearchMultiItem
import com.zaurh.movietimenew.util.EMPTY
import com.zaurh.movietimenew.util.ZERO

data class SearchUIState(
    val isLoading: Boolean = false,
    val page: Int = 1,
    val totalPages: Int = ZERO,
    val totalResults: Int = ZERO,
    val searchQuery: String = EMPTY,
    val searchFilterType: SearchFilterType = SearchFilterType.ALL,
    val searchFilterSortType: SearchFilterSortType = SearchFilterSortType.POPULARITY,
    val searchedMulti: List<SearchMultiItem> = emptyList(),
    val pageSwitcherShown: Boolean = false,
    val trendingTextShown: Boolean = false,
    val searchFilterBottomSheetEnabled: Boolean = false,
    val releaseDateShown: Boolean = false,
    val message: String = EMPTY
)

sealed interface SearchAction {
    data class OnSearchQueryChanged(val query: String) : SearchAction
    data object OnPreviousPageClicked : SearchAction
    data object OnNextPageClicked : SearchAction
    data class OnMovieClicked(val movieId: Long) : SearchAction
    data class OnPersonClicked(val personId: Long) : SearchAction
    data class OnTvClicked(val seriesId: Long) : SearchAction
    data object OnFilterClicked : SearchAction
    data class OnFilterTypeChanged(val type: SearchFilterType) : SearchAction
    data class OnFilterSortTypeChanged(val type: SearchFilterSortType) : SearchAction
    data object OnFilterBSDismissed : SearchAction
    data object OnToggleShowReleaseDate : SearchAction
}

sealed interface SearchSideEffect {
    data object ScrollToTop : SearchSideEffect
    data class NavigateToDetailsScreen(val movieId: Long) : SearchSideEffect
    data class NavigateToPersonScreen(val personId: Long) : SearchSideEffect
    data class NavigateToTvScreen(val seriesId: Long) : SearchSideEffect
}

enum class SearchType(val typeName: String, val displayName: String) {
    MOVIE("movie", "Movie"),
    PERSON("person", "Person"),
    TV("tv", "TV")
}

enum class SearchFilterType(val displayName: String) {
    ALL("All"),
    MOVIE("Movie"),
    PERSON("Person"),
    TV("TV")
}

enum class SearchFilterSortType(val displayName: String) {
    POPULARITY("Popularity"),
    RELEASE_DATE("Release date"),
    VOTE_COUNT("Vote count"),
    MOST_LIKED("Most liked")
}