package com.zaurh.movietimenew.presentation.tv

import com.zaurh.movietimenew.data.models.user.UserData
import com.zaurh.movietimenew.domain.models.tv.tv_credits.TvCreditsCast
import com.zaurh.movietimenew.domain.models.tv.tv_similar.TvSimilarItem
import com.zaurh.movietimenew.presentation.model.ProviderUIModel
import com.zaurh.movietimenew.presentation.model.TvDetailsUIModel
import com.zaurh.movietimenew.util.EMPTY

data class TvDetailsUIState(
    val isLoading: Boolean = false,
    val userData: UserData? = null,
    val tvDetails: TvDetailsUIModel? = null,
    val isFavorite: Boolean = false,
    val similar: List<TvSimilarItem> = listOf(),
    val trailerKey: String = EMPTY,
//    val allReviews: List<ReviewData> = listOf(),
    val watchProviders: List<ProviderUIModel> = listOf(),
    val credits: List<TvCreditsCast> = listOf(),
    val reviewValue: String = EMPTY,
    val reviewError: String = EMPTY,
    val reviewAlert: Boolean = false,
//    val selectedReviewRate: Rate = Rate.NONE,
    val gameBottomSheetEnabled: Boolean = false
)

sealed interface TvDetailsAction {
    data object OnInit : TvDetailsAction
    data object OnBackClicked : TvDetailsAction
    data class OnTvSeriesClicked(val seriesId: Long) : TvDetailsAction
    data object ToggleFavorite : TvDetailsAction
    data object OnSignInClicked : TvDetailsAction
    data object OnAddReviewClicked : TvDetailsAction
    data object OnReviewAlertClosed : TvDetailsAction
    data class OnReviewValueChange(val value: String) : TvDetailsAction
//    data class OnReviewRateSelected(val rate: Rate) : TvDetailsAction
    data object OnAddReview : TvDetailsAction
    data class OnCastClick(val castId: Long) : TvDetailsAction
    data object OnWallpapersClicked : TvDetailsAction
    data object OnGameClicked : TvDetailsAction
    data object OnGameBottomSheetDismissed: TvDetailsAction
    data class OnGameModeClicked(val gameMode: String): TvDetailsAction
}

sealed interface TvDetailsSideEffect {
    data object NavigateBack : TvDetailsSideEffect
    data object NavigateToSignIn : TvDetailsSideEffect
    data class NavigateToCast(val castId: Long) : TvDetailsSideEffect
    data class ShowError(val message: String) : TvDetailsSideEffect
    data class NavigateToWallpapers(val seriesId: Long) : TvDetailsSideEffect
    data class NavigateToGamePopularScreen(val seriesId: String, val gameMode: String) : TvDetailsSideEffect
}