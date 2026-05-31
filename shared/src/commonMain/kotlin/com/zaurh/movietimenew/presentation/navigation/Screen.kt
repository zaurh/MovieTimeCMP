package com.zaurh.movietimenew.presentation.navigation

sealed class Screen(val route: String) {
    data object DiscoverScreen : Screen("discover_screen/{genreName}/{genreId}")
    data object SignInScreen : Screen("sign_in_screen")
    data object SignUpScreen : Screen("sign_up_screen")
    data object AccountScreen : Screen("account_screen")
    data object PreferencesScreen : Screen("preferences_screen")
    data object ReviewsScreen : Screen("reviews_screen")
    data object HomeScreen : Screen("home_screen")
    data object DetailsScreen : Screen("details_screen/{movieId}")
    data object PersonScreen : Screen("person_screen/{personId}")
    data object TvDetailsScreen : Screen("tv_details_screen/{seriesId}")
    data object WallpaperScreen : Screen("wallpaper_screen/{id}/{contentType}")
    data object GamePopularScreen :
        Screen("game_popular_screen?difficulty={difficulty}&type={type}&movieId={movieId}&seriesId={seriesId}")
}