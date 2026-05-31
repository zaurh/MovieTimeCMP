package com.zaurh.movietimenew.presentation.discover

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zaurh.movietimenew.domain.repository.DiscoverRepository
import com.zaurh.movietimenew.presentation.details.DetailsSideEffect
import com.zaurh.movietimenew.presentation.discover.states.DiscoverEvent
import com.zaurh.movietimenew.presentation.discover.states.DiscoverSideEffect
import com.zaurh.movietimenew.presentation.discover.states.DiscoverSideEffect.*
import com.zaurh.movietimenew.presentation.discover.states.DiscoverUIState
import com.zaurh.movietimenew.presentation.mapper.discover.toUIModel
import com.zaurh.movietimenew.util.onError
import com.zaurh.movietimenew.util.onSuccess
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class DiscoverViewModel(
    private val discoverRepository: DiscoverRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _uiState = MutableStateFlow(DiscoverUIState())
    val uiState = _uiState.asStateFlow()

    private val _sideEffect = MutableSharedFlow<DiscoverSideEffect>(extraBufferCapacity = 1)
    val sideEffect = _sideEffect.asSharedFlow()

    private val genreId by lazy { savedStateHandle.get<Long>("genreId") }
    private val genreName by lazy { savedStateHandle.get<String>("genreName") }


    fun onEvent(event: DiscoverEvent) {
        when (event) {
            DiscoverEvent.OnInit -> {
                onInit()
            }

            is DiscoverEvent.OnMovieClicked -> {
                _sideEffect.tryEmit(NavigateToDetailsScreen(event.movieId))
            }

            DiscoverEvent.OnPreviousPageClicked -> {
                val genreId = uiState.value.genreId
                discoverMovies(genreId, uiState.value.page - 1)
            }

            DiscoverEvent.OnNextPageClicked -> {
                val genreId = uiState.value.genreId
                discoverMovies(genreId, uiState.value.page + 1)
            }

            DiscoverEvent.OnNavigateBack -> {
                _sideEffect.tryEmit(DiscoverSideEffect.NavigateBack)
            }
        }
    }

    private fun onInit() {
        genreId?.let { genreId ->
            _uiState.update { it.copy(genreId = genreId, genreName = genreName.orEmpty()) }
            discoverMovies(genreId)
        }
    }

    private fun discoverMovies(genreId: Long, page: Int = 1) {
        viewModelScope.launch {
            discoverRepository.discoverMovies(genreId, page).onSuccess { result ->
                val movies = result.results
                _uiState.update {
                    it.copy(
                        page = result.page,
                        totalPages = result.totalPages,
                        totalResults = result.totalResults,
                        movies = movies.map { movie -> movie.toUIModel() }
                    )
                }
            }.onError { _, message ->
                _uiState.update { it.copy(errorMessage = message) }
            }
        }
    }
}