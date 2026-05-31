package com.zaurh.movietimenew.presentation.details

import com.zaurh.movietimenew.data.models.user.UserData
import com.zaurh.movietimenew.domain.models.movie.movie_credits.MovieCreditsCast
import com.zaurh.movietimenew.domain.models.movie.movie_recommendations.MovieRecommendationsItem
import com.zaurh.movietimenew.presentation.model.MovieDetailsUIModel
import com.zaurh.movietimenew.util.EMPTY

data class DetailsUIState(
    val isLoading: Boolean = false,
    val userData: UserData? = null,
    val movie: MovieDetailsUIModel? = null,
    val isFavorite: Boolean = false,
    val recommendations: List<MovieRecommendationsItem> = listOf(),
    val trailerKey: String = EMPTY,
//    val allReviews: List<ReviewData> = listOf(),
    val credits: List<MovieCreditsCast> = listOf(),
//    val watchProviders: List<ProviderUIModel> = listOf(),
    val reviewValue: String = EMPTY,
    val reviewError: String = EMPTY,
    val reviewAlert: Boolean = false,
//    val selectedReviewRate: Rate = Rate.NONE,
    val gameBottomSheetEnabled: Boolean = false
)

sealed interface DetailsAction {
    data object OnBackClicked : DetailsAction
    data class OnMovieClick(val movieId: Long) : DetailsAction
    data object ToggleFavorite : DetailsAction
    data object OnSignInClicked : DetailsAction
    data object OnAddReviewClicked: DetailsAction
    data object OnReviewAlertClosed : DetailsAction
    data class OnReviewValueChange(val value: String) : DetailsAction
//    data class OnReviewRateSelected(val rate: Rate) : DetailsAction
    data object OnAddReview : DetailsAction
    data class OnCastClick(val castId: Long) : DetailsAction
    data object OnWallpapersClicked : DetailsAction
    data object OnGameClicked : DetailsAction
    data object OnGameBottomSheetDismissed: DetailsAction
    data class OnGameModeClicked(val gameMode: String): DetailsAction
}

sealed interface DetailsSideEffect {
    data object NavigateBack : DetailsSideEffect
    data object NavigateToSignIn : DetailsSideEffect
    data class NavigateToCast(val castId: Long) : DetailsSideEffect
    data class ShowError(val message: String) : DetailsSideEffect
    data class NavigateToWallpapers(val movieId: Long) : DetailsSideEffect
    data class NavigateToGamePopularScreen(val movieId: String, val gameMode: String) : DetailsSideEffect
}