package com.zaurh.movietimenew.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zaurh.movietimenew.domain.repository.GenreRepository
import com.zaurh.movietimenew.presentation.main.MainSideEffect.NavigateToDetailsScreen
import com.zaurh.movietimenew.presentation.main.MainSideEffect.NavigateToDiscoverScreen
import com.zaurh.movietimenew.domain.repository.MovieRepository
import com.zaurh.movietimenew.util.onError
import com.zaurh.movietimenew.util.onSuccess
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel(
    private val movieRepository: MovieRepository,
    private val genreRepository: GenreRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(MainUIState())
    val uiState = _uiState.asStateFlow()

    private val _sideEffect = MutableSharedFlow<MainSideEffect>(extraBufferCapacity = 1)
    val sideEffect = _sideEffect.asSharedFlow()

    fun onEvent(event: MainEvent) {
        when (event) {
            MainEvent.OnInit -> {
                onInit()
            }

            is MainEvent.OnMovieClicked -> {
                _sideEffect.tryEmit(NavigateToDetailsScreen(event.movieId))
            }

            is MainEvent.OnGenreClicked -> {
                _sideEffect.tryEmit(NavigateToDiscoverScreen(event.genreName, event.genreId))
            }
        }
    }

    private fun onInit() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }

            val genres = async { genreRepository.getGenres() }
            val upcoming = async { movieRepository.getUpcomingMovies() }
            val popular = async { movieRepository.getPopularMovies() }
            val nowPlaying = async { movieRepository.getNowPlayingMovies() }
            val topRated = async { movieRepository.getTopRatedMovies() }

            val upcomingResult = upcoming.await()
            val popularResult = popular.await()
            val nowPlayingResult = nowPlaying.await()
            val topRatedResult = topRated.await()
            val genresResult = genres.await()

            var newState = _uiState.value

            genresResult.onSuccess {
                newState = newState.copy(genres = it.genres)
            }
            upcomingResult.onSuccess {
                newState = newState.copy(upcomingMovies = it.results)
            }
            popularResult.onSuccess {
                newState = newState.copy(popularMovies = it.results)
            }
            nowPlayingResult.onSuccess {
                newState = newState.copy(nowPlayingMovies = it.results)
            }
            topRatedResult.onSuccess {
                newState = newState.copy(topRatedMovies = it.results)
            }

            _uiState.update { newState.copy(isLoading = false) }
        }
    }
}