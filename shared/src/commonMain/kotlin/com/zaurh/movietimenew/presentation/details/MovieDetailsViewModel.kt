package com.zaurh.movietimenew.presentation.details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zaurh.movietimenew.domain.repository.MovieRepository
import com.zaurh.movietimenew.presentation.mapper.movie.toUIModel
import com.zaurh.movietimenew.util.onSuccess
import com.zaurh.movietimenew.util.orZero
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MovieDetailsViewModel (
    private val movieRepository: MovieRepository,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val _uiState = MutableStateFlow(DetailsUIState())
    val uiState = _uiState.asStateFlow()

    private val _sideEffect = MutableSharedFlow<DetailsSideEffect>(extraBufferCapacity = 1)
    val sideEffect = _sideEffect.asSharedFlow()

    private val movieId by lazy { savedStateHandle.get<Long>("movieId") }

    init {
        onInit()
    }

    override fun onCleared() {
        super.onCleared()
    }

    fun onAction(event: DetailsAction) {
        when (event) {
            is DetailsAction.OnMovieClick -> {
                onMovieClick(event.movieId)
            }

            is DetailsAction.ToggleFavorite -> {
//                toggleFavorite()
            }

            DetailsAction.OnSignInClicked -> {
                _sideEffect.tryEmit(DetailsSideEffect.NavigateToSignIn)
            }

            is DetailsAction.OnAddReviewClicked -> {
                _uiState.update { it.copy(reviewAlert = true) }
            }

            is DetailsAction.OnReviewAlertClosed -> {
                _uiState.update { it.copy(reviewAlert = false) }
            }

            is DetailsAction.OnReviewValueChange -> {
                onRateValueChange(event.value)
            }

//            is DetailsAction.OnReviewRateSelected -> {
//                _uiState.update { it.copy(selectedReviewRate = event.rate) }
//            }

            DetailsAction.OnAddReview -> {
//                addReview()
            }

            DetailsAction.OnBackClicked -> {
                _sideEffect.tryEmit(DetailsSideEffect.NavigateBack)
            }

            is DetailsAction.OnCastClick -> {
                _sideEffect.tryEmit(DetailsSideEffect.NavigateToCast(event.castId))
            }

            DetailsAction.OnWallpapersClicked -> {
                val movieId = uiState.value.movie?.id.orZero()
                _sideEffect.tryEmit(DetailsSideEffect.NavigateToWallpapers(movieId))
            }

            DetailsAction.OnGameClicked -> {
                _uiState.update { it.copy(gameBottomSheetEnabled = true) }
            }

            DetailsAction.OnGameBottomSheetDismissed -> {
                _uiState.update { it.copy(gameBottomSheetEnabled = false) }
            }

            is DetailsAction.OnGameModeClicked -> {
                _uiState.update { it.copy(gameBottomSheetEnabled = false) }

                _sideEffect.tryEmit(
                    DetailsSideEffect.NavigateToGamePopularScreen(
                        movieId = uiState.value.movie?.id.toString(),
                        gameMode = event.gameMode
                    )
                )
            }
        }
    }

    private fun onInit() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
//            authRepository.getCurrentUser().onSuccess { result ->
//                analyticsManager.logEvent(DetailsEvents.DET_NETWORK_FIREBASE_GET_USER_SUCCESS)
//                databaseRepository.getUserData(result.uid).onSuccess { userData ->
//                    analyticsManager.logEvent(
//                        name = DetailsEvents.DET_NETWORK_GET_USER_SUCCESS,
//                        properties = mapOf(
//                            DetailsParams.DET_USER_ID to userData.id,
//                            DetailsParams.DET_USERNAME to userData.username
//                        )
//                    )
//                    _uiState.update { it.copy(userData = userData) }
//                    uiState.value.movie?.let {
//                        checkIfFavorite(movie = it.toFavoriteData())
//                    }
//                }.onError { _, message ->
//                    analyticsManager.logEvent(
//                        name = DetailsEvents.DET_NETWORK_GET_USER_ERROR,
//                        properties = mapOf(
//                            DetailsParams.DET_ERROR_MESSAGE to message
//                        )
//                    )
//                }
//            }.onError { _, message ->
//                analyticsManager.logEvent(
//                    name = DetailsEvents.DET_NETWORK_FIREBASE_GET_USER_ERROR,
//                    properties = mapOf(
//                        DetailsParams.DET_ERROR_MESSAGE to message
//                    )
//                )
//            }

            movieId?.let {
                getMovieDetails(it)
            }
            _uiState.update { it.copy(isLoading = false) }
        }
    }

    private fun onMovieClick(movieId: Long) {
        getMovieDetails(movieId)
    }

    private fun getMovieDetails(movieId: Long) {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }

            val movieDeferred = async { movieRepository.getMovieDetails(movieId) }
            val recommendationsDeferred = async { movieRepository.getRecommendations(movieId) }
            val trailerDeferred = async { movieRepository.getMovieVideo(movieId) }
//            val reviewsDeferred = async { reviewRepository.getReviews(movieId) }
            val peopleDeferred = async { movieRepository.getCredits(movieId, "en") }
            val watchProvidersDeferred = async { movieRepository.getMovieWatchProviders(movieId) }

            val movieResult = movieDeferred.await()
            val recommendationsResult = recommendationsDeferred.await()
            val trailerResult = trailerDeferred.await()
//            val reviewsResult = reviewsDeferred.await()
            val peopleResult = peopleDeferred.await()
            val watchProvidersResult = watchProvidersDeferred.await()

            var newState = _uiState.value

//            var favoriteData: FavoriteData? = null

            movieResult.onSuccess { movieDetails ->
                newState = newState.copy(movie = movieDetails.toUIModel())
//                favoriteData = movieDetails.toFavoriteData()
            }

            recommendationsResult.onSuccess { recommendations ->
                newState = newState.copy(recommendations = recommendations.results)
            }

            trailerResult.onSuccess { trailers ->
                newState = newState.copy(
                    trailerKey = trailers.results.firstOrNull()?.key.orEmpty()
                )
            }
//            reviewsResult.onSuccess { reviews ->
//                analyticsManager.logEvent(DetailsEvents.DET_NETWORK_GET_REVIEWS_SUCCESS)
//                val sorted = reviews.sortedByDescending { it.timestamp }
//                newState = newState.copy(
//                    allReviews = sorted,
//                    reviewError = if (reviews.isEmpty()) UIText.StringResource(R.string.movie_details_no_reviews_yet) else null
//                )
//            }.onError { _, message ->
//                analyticsManager.logEvent(
//                    name = DetailsEvents.DET_NETWORK_GET_REVIEWS_ERROR,
//                    properties = mapOf(
//                        DetailsParams.DET_ERROR_MESSAGE to message
//                    )
//                )
//            }

            peopleResult.onSuccess { people ->
                newState = newState.copy(credits = people.cast)
            }
//            watchProvidersResult.onSuccess { providers ->
//                val providerUiList: List<ProviderUIModel> =
//                    providers.results.values
//                        .flatMap { country ->
//                            listOfNotNull(
//                                country.flatrate,
//                                country.rent,
//                                country.buy
//                            ).flatten()
//                        }
//                        .distinctBy { it.providerId }
//                        .map { provider ->
//                            ProviderUIModel(
//                                id = provider.providerId,
//                                name = provider.providerName,
//                                logoRes = Provider.getProviderLogo(provider.providerId),
//                                actionUrl = Provider.buildProviderUrl(
//                                    provider.providerId,
//                                    newState.movie?.title.orEmpty()
//                                )
//                            )
//                        }
//
//                newState = newState.copy(
//                    watchProviders = providerUiList
//                )
//            }

            _uiState.update { newState.copy(isLoading = false) }

//            favoriteData?.let {
//                checkIfFavorite(it)
//            }
        }
    }

//    private fun checkIfFavorite(
//        movie: FavoriteData
//    ) {
//        val userData = uiState.value.userData
//        userData?.let { user ->
//            _uiState.update { it.copy(isFavorite = user.favoriteMovies.contains(movie)) }
//        }
//    }

    private fun onRateValueChange(value: String) {
        _uiState.update { it.copy(reviewValue = value) }
    }

//    private fun addReview() {
//        viewModelScope.launch(Dispatchers.IO) {
//            _uiState.update { it.copy(isLoading = true) }
//            val movie = uiState.value.movie
//            val author = uiState.value.userData
//
//            val reviewData = ReviewData(
//                id = UUID.randomUUID().toString(),
//                author = author,
//                opinion = uiState.value.reviewValue,
//                rate = uiState.value.selectedReviewRate,
//                movie = movie?.toDomain()
//            )
//
//            reviewRepository.addReview(reviewData).onSuccess {
//                analyticsManager.logEvent(
//                    name = DetailsEvents.DET_NETWORK_ADD_REVIEW_SUCCESS,
//                    properties = mapOf(
//                        DetailsParams.DET_MOVIE_ID to movie?.id.orZero(),
//                        DetailsParams.DET_MOVIE_NAME to movie?.title.orEmpty(),
//                        DetailsParams.DET_REVIEW_VALUE to uiState.value.reviewValue,
//                        DetailsParams.DET_REVIEW_RATE to uiState.value.selectedReviewRate.name
//                    )
//                )
//                _uiState.update {
//                    it.copy(
//                        allReviews = listOf(reviewData) + it.allReviews,
//                        reviewAlert = false,
//                        reviewError = null
//                    )
//                }
//            }.onError { _, message ->
//                analyticsManager.logEvent(
//                    name = DetailsEvents.DET_NETWORK_ADD_REVIEW_ERROR,
//                    properties = mapOf(
//                        DetailsParams.DET_MOVIE_ID to movie?.id.orZero(),
//                        DetailsParams.DET_MOVIE_NAME to movie?.title.orEmpty(),
//                        DetailsParams.DET_ERROR_MESSAGE to message,
//                        DetailsParams.DET_REVIEW_VALUE to uiState.value.reviewValue,
//                        DetailsParams.DET_REVIEW_RATE to uiState.value.selectedReviewRate.name
//                    )
//                )
//            }
//            _uiState.update { it.copy(isLoading = false) }
//        }
//    }

//    private fun toggleFavorite() {
//        viewModelScope.launch(Dispatchers.IO) {
//            val userData = uiState.value.userData
//
//            if (userData == null) {
//                _sideEffect.tryEmit(DetailsSideEffect.NavigateToSignIn)
//                return@launch
//            }
//
//            uiState.value.movie?.let { movieData ->
//                if (uiState.value.isFavorite) {
//                    databaseRepository.removeFromFavorites(
//                        movie = movieData.toFavoriteData(),
//                        userId = userData.id
//                    ).onSuccess {
//                        analyticsManager.logEvent(
//                            name = DetailsEvents.DET_NETWORK_REMOVE_FROM_FAVORITES_SUCCESS,
//                            properties = mapOf(
//                                DetailsParams.DET_MOVIE_ID to movieData.id,
//                                DetailsParams.DET_MOVIE_NAME to movieData.title
//                            )
//                        )
//                        _uiState.update { it.copy(isFavorite = false) }
//                    }.onError { _, message ->
//                        analyticsManager.logEvent(
//                            name = DetailsEvents.DET_NETWORK_REMOVE_FROM_FAVORITES_ERROR,
//                            properties = mapOf(
//                                DetailsParams.DET_ERROR_MESSAGE to message,
//                                DetailsParams.DET_MOVIE_ID to movieData.id,
//                                DetailsParams.DET_MOVIE_NAME to movieData.title
//                            )
//                        )
//                    }
//                } else {
//                    databaseRepository.addToFavorites(
//                        movie = movieData.toFavoriteData(),
//                        userId = userData.id
//                    ).onSuccess {
//                        analyticsManager.logEvent(
//                            name = DetailsEvents.DET_NETWORK_ADD_TO_FAVORITES_SUCCESS,
//                            properties = mapOf(
//                                DetailsParams.DET_MOVIE_ID to movieData.id,
//                                DetailsParams.DET_MOVIE_NAME to movieData.title
//                            )
//                        )
//                        _uiState.update { it.copy(isFavorite = true) }
//                    }.onError { _, message ->
//                        analyticsManager.logEvent(
//                            name = DetailsEvents.DET_NETWORK_ADD_TO_FAVORITES_ERROR,
//                            properties = mapOf(
//                                DetailsParams.DET_ERROR_MESSAGE to message,
//                                DetailsParams.DET_MOVIE_ID to movieData.id,
//                                DetailsParams.DET_MOVIE_NAME to movieData.title
//                            )
//                        )
//                    }
//                }
//            }
//        }
//    }
}