package com.zaurh.movieappintern2.presentation.tv

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zaurh.movietimenew.domain.repository.TvRepository
import com.zaurh.movietimenew.presentation.mapper.tv.toUIModel
import com.zaurh.movietimenew.presentation.tv.TvDetailsAction
import com.zaurh.movietimenew.presentation.tv.TvDetailsSideEffect
import com.zaurh.movietimenew.presentation.tv.TvDetailsUIState
import com.zaurh.movietimenew.util.onSuccess
import com.zaurh.movietimenew.util.orZero
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class TvDetailsViewModel(
    private val tvRepository: TvRepository,
    private val savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val _uiState = MutableStateFlow(TvDetailsUIState())
    val uiState = _uiState.asStateFlow()

    private val _sideEffect = MutableSharedFlow<TvDetailsSideEffect>(extraBufferCapacity = 1)
    val sideEffect = _sideEffect.asSharedFlow()

    private val seriesId by lazy { savedStateHandle.get<Long>("seriesId") }

    fun onEvent(action: TvDetailsAction) {
        when (action) {
            TvDetailsAction.OnInit -> {
                onInit()
            }

            is TvDetailsAction.OnTvSeriesClicked -> {
                onSeriesClicked(action.seriesId)
            }

            is TvDetailsAction.ToggleFavorite -> {
//                toggleFavorite()
            }

            TvDetailsAction.OnSignInClicked -> {
                _sideEffect.tryEmit(TvDetailsSideEffect.NavigateToSignIn)
            }

            is TvDetailsAction.OnAddReviewClicked -> {
                _uiState.update { it.copy(reviewAlert = true) }
            }

            is TvDetailsAction.OnReviewAlertClosed -> {
                _uiState.update { it.copy(reviewAlert = false) }
            }

            is TvDetailsAction.OnReviewValueChange -> {
                onRateValueChange(action.value)
            }

//            is TvDetailsAction.OnReviewRateSelected -> {
//                _uiState.update { it.copy(selectedReviewRate = action.rate) }
//            }

            TvDetailsAction.OnAddReview -> {
//                addReview()
            }

            TvDetailsAction.OnBackClicked -> {
                _sideEffect.tryEmit(TvDetailsSideEffect.NavigateBack)
            }

            is TvDetailsAction.OnCastClick -> {
                _sideEffect.tryEmit(TvDetailsSideEffect.NavigateToCast(action.castId))
            }

            TvDetailsAction.OnWallpapersClicked -> {
                val seriesId = uiState.value.tvDetails?.id.orZero()
                _sideEffect.tryEmit(TvDetailsSideEffect.NavigateToWallpapers(seriesId.orZero()))
            }

            TvDetailsAction.OnGameBottomSheetDismissed -> {
                _uiState.update { it.copy(gameBottomSheetEnabled = false) }
            }

            TvDetailsAction.OnGameClicked -> {
                _uiState.update { it.copy(gameBottomSheetEnabled = true) }
            }

            is TvDetailsAction.OnGameModeClicked -> {
                _uiState.update { it.copy(gameBottomSheetEnabled = false) }

                _sideEffect.tryEmit(
                    TvDetailsSideEffect.NavigateToGamePopularScreen(
                        seriesId = uiState.value.tvDetails?.id.toString(),
                        gameMode = action.gameMode
                    )
                )
            }
        }
    }

    private fun onInit() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            seriesId?.let {
                getTvDetails(it)
            }

            _uiState.update { it.copy(isLoading = false) }
        }
    }

    private fun onSeriesClicked(seriesId: Long) {
        getTvDetails(seriesId)
    }

    private fun getTvDetails(seriesId: Long) {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }

            val tvDetailsDeferred = async { tvRepository.getTvDetails(seriesId) }
            val tvDetailsVideoDeferred = async { tvRepository.getTvDetailsVideo(seriesId) }
            val tvSimilarDeferred = async { tvRepository.getTvSimilar(seriesId) }
            val tvWatchProvidersDeferred = async { tvRepository.getTvWatchProviders(seriesId) }
            val tvCreditsDeferred =
                async { tvRepository.getTvCredits(seriesId = seriesId, language = "en") }

            val tvDetailsResult = tvDetailsDeferred.await()
            val tvDetailsVideoResult = tvDetailsVideoDeferred.await()
            val tvSimilarResult = tvSimilarDeferred.await()
            val tvWatchProvidersResult = tvWatchProvidersDeferred.await()
            val tvCreditsResult = tvCreditsDeferred.await()

            var newState = _uiState.value

            tvDetailsResult.onSuccess { tvDetails ->
                newState = newState.copy(tvDetails = tvDetails.toUIModel())
            }

            tvDetailsVideoResult.onSuccess { tvVideos ->
                newState = newState.copy(trailerKey = tvVideos.results.firstOrNull()?.key.orEmpty())
            }

            tvSimilarResult.onSuccess { tvSimilar ->
                newState = newState.copy(similar = tvSimilar.results)
            }

            tvCreditsResult.onSuccess { credits ->
                newState = newState.copy(credits = credits.cast)
            }

//            tvWatchProvidersResult.onSuccess { providers ->
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
//                                    newState.tvDetails?.title.orEmpty()
//                                )
//                            )
//                        }
//
//                newState = newState.copy(
//                    watchProviders = providerUiList
//                )
//            }

            _uiState.update { newState.copy(isLoading = false) }
        }
    }

    private fun onRateValueChange(value: String) {
        _uiState.update { it.copy(reviewValue = value) }
    }
}