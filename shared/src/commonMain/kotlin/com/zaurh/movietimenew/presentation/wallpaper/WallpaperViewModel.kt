package com.zaurh.movietimenew.presentation.wallpaper

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zaurh.movietimenew.domain.repository.MovieRepository
import com.zaurh.movietimenew.domain.repository.PeopleRepository
import com.zaurh.movietimenew.domain.repository.TvRepository
import com.zaurh.movietimenew.presentation.mapper.movie.toUIModel
import com.zaurh.movietimenew.presentation.mapper.person.toUIModel
import com.zaurh.movietimenew.presentation.mapper.tv.toUIModel
import com.zaurh.movietimenew.util.onSuccess
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onSubscription
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class WallpaperViewModel(
    private val movieRepository: MovieRepository,
    private val peopleRepository: PeopleRepository,
    private val tvRepository: TvRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _uiState = MutableStateFlow(WallpaperUIState())
    val uiState = _uiState.asStateFlow()

    private val _sideEffect = MutableSharedFlow<WallpaperSideEffect>(extraBufferCapacity = 1)
    val sideEffect = _sideEffect.asSharedFlow().onSubscription {
        onInit()
    }

    private val id by lazy { savedStateHandle.get<Long>("id") }
    private val contentType by lazy { savedStateHandle.get<String>("contentType") }

    fun onAction(action: WallpaperAction) {
        when (action) {
            WallpaperAction.OnBackClicked -> {
                _sideEffect.tryEmit(WallpaperSideEffect.NavigateBack)
            }

            WallpaperAction.OnDownloadClicked -> {
                _sideEffect.tryEmit(WallpaperSideEffect.DownloadImage)
            }

            is WallpaperAction.OnImageTypeChanged -> {
                _uiState.update { it.copy(imageType = action.imageType) }
            }

            WallpaperAction.OnMoreBottomSheetDismissed -> {
                _uiState.update { it.copy(moreBottomSheetEnabled = false) }
                when (uiState.value.contentType) {
                    ContentType.MOVIE.name -> getMovieImages()
                    ContentType.PERSON.name -> getPersonImages()
                    ContentType.TV.name -> getTvImages()
                }
            }

            WallpaperAction.OnMoreClicked -> {
                _uiState.update { it.copy(moreBottomSheetEnabled = true) }
            }

            WallpaperAction.OnSetWallpaperClicked -> {
                _uiState.update { it.copy(moreBottomSheetEnabled = false) }
                _sideEffect.tryEmit(WallpaperSideEffect.SetAsWallpaper)
            }

            WallpaperAction.OnWallpaperSeen -> {
//                viewModelScope.launch {
//                    dataStoreSettings.saveWallpaperSeen(true)
//                }
            }
        }
    }

    private fun onInit() {
        _uiState.update { it.copy(contentType = contentType.orEmpty()) }
        when (contentType) {
            ContentType.TV.name -> {
                getTvImages()
            }

            ContentType.MOVIE.name -> {
                getMovieImages()
            }

            ContentType.PERSON.name -> {
                getPersonImages()
            }
        }
    }

    private fun getMovieImages() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            val imageType = uiState.value.imageType

            id?.let { id ->
                movieRepository.getMovieImages(id).onSuccess { result ->
                    when (imageType) {
                        ImageType.BACKDROP -> _uiState.update { it.copy(images = result.backdrops.map { backdrops -> backdrops.toUIModel() }) }
                        ImageType.LOGO -> _uiState.update { it.copy(images = result.logos.map { logos -> logos.toUIModel() }) }
                        ImageType.POSTER -> _uiState.update { it.copy(images = result.posters.map { posters -> posters.toUIModel() }) }
                    }
                }
            }
            _uiState.update { it.copy(isLoading = false) }
        }
    }

    private fun getPersonImages() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }

            id?.let { id ->
                peopleRepository.getPersonImages(id).onSuccess { result ->
                    _uiState.update { it.copy(images = result.profiles.map { profiles -> profiles.toUIModel() }) }
                }
                _uiState.update { it.copy(isLoading = false) }
            }
        }
    }

    private fun getTvImages() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }

            id?.let { id ->
                tvRepository.getTvImages(id).onSuccess { result ->
                    when (uiState.value.imageType) {
                        ImageType.BACKDROP -> _uiState.update { it.copy(images = result.backdrops.map { backdrops -> backdrops.toUIModel() }) }
                        ImageType.LOGO -> _uiState.update { it.copy(images = result.logos.map { logos -> logos.toUIModel() }) }
                        ImageType.POSTER -> _uiState.update { it.copy(images = result.posters.map { posters -> posters.toUIModel() }) }
                    }
                }
                _uiState.update { it.copy(isLoading = false) }
            }
        }
    }
}