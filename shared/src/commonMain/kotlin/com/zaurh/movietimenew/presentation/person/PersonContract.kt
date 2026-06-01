package com.zaurh.movietimenew.presentation.person

import com.zaurh.movietimenew.domain.models.person.person_movies.PersonMoviesCastItem
import com.zaurh.movietimenew.domain.models.person.person_details.PersonDetails
import com.zaurh.movietimenew.domain.models.person.person_social_media.PersonSocialMedia
import com.zaurh.movietimenew.domain.models.person.person_tv.PersonTvCastItem

data class PersonUIState(
    val isLoading: Boolean = false,
    val isFavorite: Boolean = false,
    val person: PersonDetails? = null,
    val personMovies: List<PersonMoviesCastItem> = listOf(),
    val personTvShows: List<PersonTvCastItem> = listOf(),
    val personSocialMedia: PersonSocialMedia? = null
)

sealed interface PersonAction {
    data object OnInit : PersonAction
    data object OnBackClicked : PersonAction
    data class OnMovieClicked(val movieId: Long) : PersonAction
    data class OnTvShowClicked(val seriesId: Long) : PersonAction
    data class OnSocialMediaClicked(val url: String) : PersonAction
    data object OnWallpapersClicked : PersonAction
}

sealed interface PersonSideEffect {
    data object NavigateBack : PersonSideEffect
    data object NavigateToSignIn : PersonSideEffect
    data class ShowError(val message: String) : PersonSideEffect
    data class NavigateToMovie(val movieId: Long) : PersonSideEffect
    data class NavigateToTvShows(val seriesId: Long) : PersonSideEffect
    data class NavigateToSocialMedia(val url: String) : PersonSideEffect
    data class NavigateToWallpapers(val personId: Long) : PersonSideEffect
}