package com.zaurh.movietimenew.presentation.home

import com.zaurh.movietimenew.data.models.user.UserData

data class HomeUIState(
    val isLoading: Boolean = false,
    val userData: UserData? = null
)

sealed interface HomeEvent {
    object OnInit : HomeEvent
}

sealed interface HomeSideEffect {

}