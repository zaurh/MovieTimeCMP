package com.zaurh.movietimenew.presentation.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zaurh.movietimenew.data.mapper.search.toMultiItem
import com.zaurh.movietimenew.domain.repository.SearchRepository
import com.zaurh.movietimenew.util.EMPTY
import com.zaurh.movietimenew.util.onError
import com.zaurh.movietimenew.util.onSuccess
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SearchViewModel(
    private val searchRepository: SearchRepository,
//    private val trendingRepository: TrendingRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(SearchUIState())
    val uiState = _uiState.asStateFlow()

    private val _sideEffect = MutableSharedFlow<SearchSideEffect>(extraBufferCapacity = 1)
    val sideEffect = _sideEffect.asSharedFlow()

    init {
        getTrendingAll()
    }

    fun onAction(action: SearchAction) {
        when (action) {
            is SearchAction.OnPreviousPageClicked -> {
                changePage(uiState.value.page - 1)
            }

            is SearchAction.OnNextPageClicked -> {
                changePage(uiState.value.page + 1)
            }

            is SearchAction.OnSearchQueryChanged -> {
                setSearchQuery(action.query)
            }

            is SearchAction.OnMovieClicked -> {
                _sideEffect.tryEmit(SearchSideEffect.NavigateToDetailsScreen(action.movieId))
            }

            is SearchAction.OnPersonClicked -> {
                _sideEffect.tryEmit(SearchSideEffect.NavigateToPersonScreen(action.personId))
            }

            is SearchAction.OnTvClicked -> {
                _sideEffect.tryEmit(SearchSideEffect.NavigateToTvScreen(action.seriesId))
            }

            SearchAction.OnFilterClicked -> {
                _uiState.update { it.copy(searchFilterBottomSheetEnabled = true) }
            }

            is SearchAction.OnFilterTypeChanged -> {
                _uiState.update { it.copy(searchFilterType = action.type) }
            }

            SearchAction.OnFilterBSDismissed -> {
                _uiState.update { it.copy(searchFilterBottomSheetEnabled = false) }
                val trendingTextShown = uiState.value.trendingTextShown

                when (uiState.value.searchFilterType) {
                    SearchFilterType.MOVIE -> {
                        if (trendingTextShown) {
                            getTrendingMovies()
                        } else {
                            searchMovies(uiState.value.searchQuery, uiState.value.page)
                        }
                    }

                    SearchFilterType.PERSON -> {
                        if (trendingTextShown) {
                            getTrendingPeople()
                        } else {
                            searchPerson(uiState.value.searchQuery, uiState.value.page)
                        }
                    }

                    SearchFilterType.TV -> {
                        if (trendingTextShown) {
                            getTrendingTv()
                        } else {
                            searchTv(uiState.value.searchQuery, uiState.value.page)
                        }
                    }

                    SearchFilterType.ALL -> {
                        if (trendingTextShown) {
                            getTrendingAll()
                        } else {
                            searchMulti(uiState.value.searchQuery, uiState.value.page)
                        }
                    }
                }
            }

            is SearchAction.OnFilterSortTypeChanged -> {
                _uiState.update { it.copy(searchFilterSortType = action.type) }
            }

            SearchAction.OnToggleShowReleaseDate -> {
                _uiState.update { it.copy(releaseDateShown = !it.releaseDateShown) }
            }
        }
    }

    private var searchJob: Job? = null

    private fun setSearchQuery(query: String) {
        searchJob?.cancel()
        _uiState.update { it.copy(searchQuery = query) }

        searchJob = viewModelScope.launch {
            delay(1000)

            if (query.isEmpty()) {
                getTrendingAll()
                _uiState.update { it.copy(searchFilterType = SearchFilterType.ALL) }
                return@launch
            }

            when (uiState.value.searchFilterType) {
                SearchFilterType.ALL -> searchMulti(query)
                SearchFilterType.MOVIE -> searchMovies(query)
                SearchFilterType.PERSON -> searchPerson(query)
                SearchFilterType.TV -> searchTv(query)
            }
        }
    }

    private fun changePage(page: Int) {
        viewModelScope.launch {
            when (uiState.value.searchFilterType) {
                SearchFilterType.ALL -> searchMulti(uiState.value.searchQuery, page)
                SearchFilterType.MOVIE -> searchMovies(uiState.value.searchQuery, page)
                SearchFilterType.PERSON -> searchPerson(uiState.value.searchQuery, page)
                SearchFilterType.TV -> searchTv(uiState.value.searchQuery, page)
            }
        }
    }

    private fun searchMulti(query: String, page: Int = 1) {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }

            searchRepository.searchMulti(query = query, page = page).onSuccess { result ->
                val searchedMulti = result.results

                val sortedMulti = when (uiState.value.searchFilterSortType) {
                    SearchFilterSortType.POPULARITY -> searchedMulti.sortedByDescending { it.popularity }
                    SearchFilterSortType.RELEASE_DATE -> searchedMulti.sortedByDescending { it.releaseDate.ifEmpty { it.firstAirDate } }
                    SearchFilterSortType.VOTE_COUNT -> searchedMulti.sortedByDescending { it.voteCount }
                    SearchFilterSortType.MOST_LIKED -> searchedMulti.sortedByDescending { it.voteAverage }
                }

                if (searchedMulti.isEmpty()) {
                    _uiState.update {
                        it.copy(
                            message = "Nothing found",
                            isLoading = false,
                            searchedMulti = listOf(),
                            pageSwitcherShown = false,
                            trendingTextShown = false
                        )
                    }
                    return@onSuccess
                }

                _uiState.update {
                    it.copy(
                        page = result.page,
                        totalPages = result.totalPages,
                        totalResults = result.totalResults,
                        searchedMulti = sortedMulti,
                        pageSwitcherShown = true,
                        isLoading = false,
                        message = EMPTY,
                        trendingTextShown = false
                    )
                }
                _sideEffect.tryEmit(SearchSideEffect.ScrollToTop)
            }.onError { _, message ->
                _uiState.update {
                    it.copy(
                        message = message,
                        isLoading = false,
                        pageSwitcherShown = false,
                        trendingTextShown = false
                    )
                }
            }
        }
    }

    private fun searchMovies(query: String, page: Int = 1) {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }

            searchRepository.searchMovies(query = query, page = page).onSuccess { result ->
                val searchedMovies = result.results
                val sortedMovies = when (uiState.value.searchFilterSortType) {
                    SearchFilterSortType.POPULARITY -> searchedMovies.sortedByDescending { it.popularity }
                    SearchFilterSortType.RELEASE_DATE -> searchedMovies.sortedByDescending { it.releaseDate }
                    SearchFilterSortType.VOTE_COUNT -> searchedMovies.sortedByDescending { it.voteCount }
                    SearchFilterSortType.MOST_LIKED -> searchedMovies.sortedByDescending { it.voteAverage }
                }

                if (searchedMovies.isEmpty()) {
                    _uiState.update {
                        it.copy(
                            message = "No movies found",
                            isLoading = false,
                            searchedMulti = listOf(),
                            pageSwitcherShown = false,
                            trendingTextShown = false
                        )
                    }
                    return@onSuccess
                }

                _uiState.update {
                    it.copy(
                        page = result.page,
                        totalPages = result.totalPages,
                        totalResults = result.totalResults,
                        searchedMulti = sortedMovies.map { movie -> movie.toMultiItem() },
                        pageSwitcherShown = true,
                        isLoading = false,
                        message = EMPTY,
                        trendingTextShown = false
                    )
                }
                _sideEffect.tryEmit(SearchSideEffect.ScrollToTop)
            }.onError { _, message ->
                _uiState.update {
                    it.copy(
                        message = message,
                        isLoading = false,
                        pageSwitcherShown = false,
                        trendingTextShown = false
                    )
                }
            }
        }
    }

    private fun searchPerson(query: String, page: Int = 1) {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }

            searchRepository.searchPerson(query = query, page = page).onSuccess { result ->
                val searchedPeople = result.results

                if (searchedPeople.isEmpty()) {
                    _uiState.update {
                        it.copy(
                            message = "No person found",
                            isLoading = false,
                            searchedMulti = listOf(),
                            pageSwitcherShown = false,
                            trendingTextShown = false
                        )
                    }
                    return@onSuccess
                }

                _uiState.update {
                    it.copy(
                        page = result.page,
                        totalPages = result.totalPages,
                        totalResults = result.totalResults,
                        searchedMulti = searchedPeople.map { person -> person.toMultiItem() },
                        pageSwitcherShown = true,
                        isLoading = false,
                        message = EMPTY,
                        trendingTextShown = false
                    )
                }
                _sideEffect.tryEmit(SearchSideEffect.ScrollToTop)
            }.onError { _, message ->
                _uiState.update {
                    it.copy(
                        message = message,
                        isLoading = false,
                        pageSwitcherShown = false,
                        trendingTextShown = false
                    )
                }
            }
        }
    }

    private fun searchTv(query: String, page: Int = 1) {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }

            searchRepository.searchTv(query = query, page = page).onSuccess { result ->
                val searchedTv = result.results
                val sortedTv = when (uiState.value.searchFilterSortType) {
                    SearchFilterSortType.POPULARITY -> searchedTv.sortedByDescending { it.popularity }
                    SearchFilterSortType.RELEASE_DATE -> searchedTv.sortedByDescending { it.firstAirDate }
                    SearchFilterSortType.VOTE_COUNT -> searchedTv.sortedByDescending { it.voteCount }
                    SearchFilterSortType.MOST_LIKED -> searchedTv.sortedByDescending { it.voteAverage }
                }

                if (searchedTv.isEmpty()) {
                    _uiState.update {
                        it.copy(
                            message = "No TV Shows found",
                            isLoading = false,
                            searchedMulti = listOf(),
                            pageSwitcherShown = false,
                            trendingTextShown = false
                        )
                    }
                    return@onSuccess
                }

                _uiState.update {
                    it.copy(
                        page = result.page,
                        totalPages = result.totalPages,
                        totalResults = result.totalResults,
                        searchedMulti = sortedTv.map { tv -> tv.toMultiItem() },
                        pageSwitcherShown = true,
                        isLoading = false,
                        message = EMPTY,
                        trendingTextShown = false
                    )
                }
                _sideEffect.tryEmit(SearchSideEffect.ScrollToTop)
            }.onError { _, message ->
                _uiState.update {
                    it.copy(
                        message = message,
                        isLoading = false,
                        pageSwitcherShown = false,
                        trendingTextShown = false
                    )
                }
            }
        }
    }

    private fun getTrendingAll() {
        viewModelScope.launch {
//            trendingRepository.getTrendingAll().onSuccess { result ->
//                val searchedTrendingAll = result.results
//
//                val sortedTrendingAll = when (uiState.value.searchFilterSortType) {
//                    SearchFilterSortType.POPULARITY -> searchedTrendingAll.sortedByDescending { it.popularity }
//                    SearchFilterSortType.RELEASE_DATE -> searchedTrendingAll.sortedByDescending { it.releaseDate.ifEmpty { it.firstAirDate } }
//                    SearchFilterSortType.VOTE_COUNT -> searchedTrendingAll.sortedByDescending { it.voteCount }
//                    SearchFilterSortType.MOST_LIKED -> searchedTrendingAll.sortedByDescending { it.voteAverage }
//                }
//
//                _uiState.update {
//                    it.copy(
//                        totalResults = result.totalResults,
//                        totalPages = result.totalPages,
//                        page = result.page,
//                        searchedMulti = sortedTrendingAll.map { all -> all.toMultiItem() },
//                        pageSwitcherShown = false,
//                        trendingTextShown = true,
//                        message = null,
//                        isLoading = false
//                    )
//                }
//                _sideEffect.tryEmit(SearchSideEffect.ScrollToTop)
//            }
        }
    }

    private fun getTrendingMovies() {
        viewModelScope.launch {
//            trendingRepository.getTrendingMovies().onSuccess { result ->
//                val searchedTrendingMovies = result.results
//
//                val sortedTrendingMovies = when (uiState.value.searchFilterSortType) {
//                    SearchFilterSortType.POPULARITY -> searchedTrendingMovies.sortedByDescending { it.popularity }
//                    SearchFilterSortType.RELEASE_DATE -> searchedTrendingMovies.sortedByDescending { it.releaseDate }
//                    SearchFilterSortType.VOTE_COUNT -> searchedTrendingMovies.sortedByDescending { it.voteCount }
//                    SearchFilterSortType.MOST_LIKED -> searchedTrendingMovies.sortedByDescending { it.voteAverage }
//                }
//
//                _uiState.update {
//                    it.copy(
//                        totalResults = result.totalResults,
//                        totalPages = result.totalPages,
//                        page = result.page,
//                        searchedMulti = sortedTrendingMovies.map { all -> all.toMultiItem() },
//                        pageSwitcherShown = false,
//                        trendingTextShown = true,
//                        message = null,
//                        isLoading = false
//                    )
//                }
//                _sideEffect.tryEmit(SearchSideEffect.ScrollToTop)
//            }
        }
    }

    private fun getTrendingPeople() {
        viewModelScope.launch {
//            trendingRepository.getTrendingPeople().onSuccess { result ->
//                val searchedTrendingPeople = result.results
//
//                val sortedTrendingPeople = when (uiState.value.searchFilterSortType) {
//                    SearchFilterSortType.POPULARITY -> searchedTrendingPeople.sortedByDescending { it.popularity }
//                    SearchFilterSortType.RELEASE_DATE -> searchedTrendingPeople.sortedByDescending { it.releaseDate }
//                    SearchFilterSortType.VOTE_COUNT -> searchedTrendingPeople.sortedByDescending { it.voteCount }
//                    SearchFilterSortType.MOST_LIKED -> searchedTrendingPeople.sortedByDescending { it.voteAverage }
//                }
//
//                _uiState.update {
//                    it.copy(
//                        totalResults = result.totalResults,
//                        totalPages = result.totalPages,
//                        page = result.page,
//                        searchedMulti = sortedTrendingPeople.map { all -> all.toMultiItem() },
//                        pageSwitcherShown = false,
//                        trendingTextShown = true,
//                        message = null,
//                        isLoading = false
//                    )
//                }
//                _sideEffect.tryEmit(SearchSideEffect.ScrollToTop)
//            }
        }
    }

    private fun getTrendingTv() {
        viewModelScope.launch {
//            trendingRepository.getTrendingTv().onSuccess { result ->
//                val searchedTrendingTv = result.results
//
//                val sortedTrendingTv = when (uiState.value.searchFilterSortType) {
//                    SearchFilterSortType.POPULARITY -> searchedTrendingTv.sortedByDescending { it.popularity }
//                    SearchFilterSortType.RELEASE_DATE -> searchedTrendingTv.sortedByDescending { it.firstAirDate }
//                    SearchFilterSortType.VOTE_COUNT -> searchedTrendingTv.sortedByDescending { it.voteCount }
//                    SearchFilterSortType.MOST_LIKED -> searchedTrendingTv.sortedByDescending { it.voteAverage }
//                }
//
//                _uiState.update {
//                    it.copy(
//                        totalResults = result.totalResults,
//                        totalPages = result.totalPages,
//                        page = result.page,
//                        searchedMulti = sortedTrendingTv.map { all -> all.toMultiItem() },
//                        pageSwitcherShown = false,
//                        trendingTextShown = true,
//                        message = null,
//                        isLoading = false
//                    )
//                }
//                _sideEffect.tryEmit(SearchSideEffect.ScrollToTop)
//            }
        }
    }
}