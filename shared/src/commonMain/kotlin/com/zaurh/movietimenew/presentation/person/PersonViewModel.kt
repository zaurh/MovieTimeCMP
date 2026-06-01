package com.zaurh.movietimenew.presentation.person

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zaurh.movietimenew.domain.repository.PeopleRepository
import com.zaurh.movietimenew.util.onSuccess
import com.zaurh.movietimenew.util.orZero
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PersonViewModel (
    private val peopleRepository: PeopleRepository,
    private val savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val _uiState = MutableStateFlow(PersonUIState())
    val uiState = _uiState.asStateFlow()

    private val _sideEffect = MutableSharedFlow<PersonSideEffect>(extraBufferCapacity = 1)
    val sideEffect = _sideEffect.asSharedFlow()

    private val personId by lazy { savedStateHandle.get<Long>("personId") }

    init {
        onInit()
    }

    fun onAction(event: PersonAction) {
        when (event) {
            PersonAction.OnInit -> {
                onInit()
            }

            PersonAction.OnBackClicked -> {
                _sideEffect.tryEmit(PersonSideEffect.NavigateBack)
            }

            is PersonAction.OnMovieClicked -> {
                _sideEffect.tryEmit(PersonSideEffect.NavigateToMovie(event.movieId))
            }

            is PersonAction.OnTvShowClicked -> {
                _sideEffect.tryEmit(PersonSideEffect.NavigateToTvShows(event.seriesId))
            }

            is PersonAction.OnSocialMediaClicked -> {
                _sideEffect.tryEmit(PersonSideEffect.NavigateToSocialMedia(event.url))
            }

            PersonAction.OnWallpapersClicked -> {
                _sideEffect.tryEmit(PersonSideEffect.NavigateToWallpapers(personId.orZero()))
            }
        }
    }

    private fun onInit() {
        viewModelScope.launch {
            personId?.let { id ->
                _uiState.update { it.copy(isLoading = true) }

                val personDetailsDeferred = async { peopleRepository.getPerson(id) }
                val personMoviesDeferred = async { peopleRepository.getPersonMovies(id) }
                val personTvShowsDeferred = async { peopleRepository.getPersonTvShows(id) }
                val personSocialDeferred = async { peopleRepository.getPersonSocialMedia(id) }

                val personDetailsResult = personDetailsDeferred.await()
                val personMoviesResult = personMoviesDeferred.await()
                val personTvShowsResult = personTvShowsDeferred.await()
                val personSocialResult = personSocialDeferred.await()

                var newState = _uiState.value

                personDetailsResult.onSuccess { person ->
                    newState = newState.copy(person = person)
                }

                personMoviesResult.onSuccess { personMovies ->
                    newState = newState.copy(personMovies = personMovies.cast)
                }
                personTvShowsResult.onSuccess { tvShows ->
                    newState = newState.copy(personTvShows = tvShows.cast)
                }

                personSocialResult.onSuccess { social ->
                    newState = newState.copy(personSocialMedia = social)
                }
                _uiState.update { newState.copy(isLoading = false) }
            }
        }
    }
}