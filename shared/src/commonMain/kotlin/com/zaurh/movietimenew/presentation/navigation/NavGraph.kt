package com.zaurh.movietimenew.presentation.navigation

import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.zaurh.movietimenew.presentation.details.DetailScreen
import com.zaurh.movietimenew.presentation.home.HomeScreen

@Composable
fun NavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    startDestination: String,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(
            route = Screen.HomeScreen.route,
            enterTransition = {
                slideInHorizontally(initialOffsetX = { it })
            },
            popEnterTransition = {
                slideInHorizontally(initialOffsetX = { -it })
            },
            exitTransition = {
                slideOutHorizontally(targetOffsetX = { -it })
            }
        ) {
            HomeScreen(
                modifier = modifier,
                navController = navController
            )
        }

//        composable(
//            route = Screen.AccountScreen.route,
//            enterTransition = {
//                slideInHorizontally(initialOffsetX = { it })
//            },
//            popExitTransition = {
//                slideOutHorizontally(targetOffsetX = { it })
//            }
//        ) {
//            AccountScreen(
//                modifier = modifier,
//                navController = navController
//            )
//        }
//
//        composable(
//            route = Screen.DiscoverScreen.route,
//            enterTransition = {
//                slideInHorizontally(initialOffsetX = { it })
//            },
//            popEnterTransition = {
//                slideInHorizontally(initialOffsetX = { -it })
//            },
//            exitTransition = {
//                slideOutHorizontally(targetOffsetX = { -it })
//            },
//            popExitTransition = {
//                slideOutHorizontally(targetOffsetX = { it })
//            },
//            arguments = listOf(
//                navArgument("genreId") { type = NavType.LongType },
//                navArgument("genreName") { type = NavType.StringType }
//            )) {
//            DiscoverScreen(
//                modifier = modifier,
//                navController = navController
//            )
//        }
//
//        composable(
//            route = Screen.PreferencesScreen.route,
//            enterTransition = {
//                slideInHorizontally(initialOffsetX = { it })
//            },
//            popExitTransition = {
//                slideOutHorizontally(targetOffsetX = { it })
//            }
//        ) {
//            PreferencesScreen(modifier = modifier)
//        }
//
//        composable(
//            route = Screen.ReviewsScreen.route,
//            enterTransition = {
//                slideInHorizontally(initialOffsetX = { it })
//            },
//            popEnterTransition = {
//                slideInHorizontally(initialOffsetX = { -it })
//            },
//            exitTransition = {
//                slideOutHorizontally(targetOffsetX = { -it })
//            },
//            popExitTransition = {
//                slideOutHorizontally(targetOffsetX = { it })
//            }
//        ) {
//            ReviewsScreen(
//                modifier = modifier,
//                navController = navController
//            )
//        }
//
        composable(
            route = Screen.DetailsScreen.route,
            arguments = listOf(navArgument("movieId") { type = NavType.LongType }
            ),
            enterTransition = {
                slideInHorizontally(initialOffsetX = { it })
            },
            popEnterTransition = {
                slideInHorizontally(initialOffsetX = { -it })
            },
            exitTransition = {
                slideOutHorizontally(targetOffsetX = { -it })
            },
            popExitTransition = {
                slideOutHorizontally(targetOffsetX = { it })
            }
        ) {
            DetailScreen(
                modifier = modifier,
                navController = navController
            )
        }
//
//        composable(
//            route = Screen.TvDetailsScreen.route,
//            arguments = listOf(navArgument("seriesId") { type = NavType.LongType }
//            ),
//            enterTransition = {
//                slideInHorizontally(initialOffsetX = { it })
//            },
//            popEnterTransition = {
//                slideInHorizontally(initialOffsetX = { -it })
//            },
//            exitTransition = {
//                slideOutHorizontally(targetOffsetX = { -it })
//            },
//            popExitTransition = {
//                slideOutHorizontally(targetOffsetX = { it })
//            }
//        ) {
//            TvDetailsScreen(
//                modifier = modifier,
//                navController = navController
//            )
//        }
//
//        composable(
//            route = Screen.PersonScreen.route,
//            arguments = listOf(navArgument("personId") { type = NavType.LongType }
//            ),
//            enterTransition = {
//                slideInHorizontally(initialOffsetX = { it })
//            },
//            popEnterTransition = {
//                slideInHorizontally(initialOffsetX = { -it })
//            },
//            exitTransition = {
//                slideOutHorizontally(targetOffsetX = { -it })
//            },
//            popExitTransition = {
//                slideOutHorizontally(targetOffsetX = { it })
//            }
//        ) {
//            PersonScreen(
//                modifier = modifier,
//                navController = navController
//            )
//        }
//
//        composable(
//            route = Screen.WallpaperScreen.route,
//            arguments = listOf(
//                navArgument("id") { type = NavType.LongType },
//                navArgument("contentType") { type = NavType.StringType }
//            ),
//            enterTransition = {
//                slideInHorizontally(initialOffsetX = { it })
//            },
//            popEnterTransition = {
//                slideInHorizontally(initialOffsetX = { -it })
//            },
//            exitTransition = {
//                slideOutHorizontally(targetOffsetX = { -it })
//            },
//            popExitTransition = {
//                slideOutHorizontally(targetOffsetX = { it })
//            }
//        ) {
//            WallpaperScreen(navController = navController)
//        }
//
//        composable(
//            route = Screen.SignInScreen.route,
//            enterTransition = {
//                slideInHorizontally(initialOffsetX = { it }) // <--
//            },
//            popExitTransition = {
//                slideOutHorizontally(targetOffsetX = { it }) // -->
//            },
//            exitTransition = {
//                slideOutHorizontally(targetOffsetX = { -it }) // <--
//            },
//            popEnterTransition = {
//                slideInHorizontally(initialOffsetX = { -it }) // -->
//            }
//        ) {
//            SignInScreen(
//                modifier = modifier,
//                navController = navController
//            )
//        }
//        composable(
//            route = Screen.SignUpScreen.route,
//            enterTransition = {
//                slideInHorizontally(initialOffsetX = { it })
//            },
//            popExitTransition = {
//                slideOutHorizontally(targetOffsetX = { it })
//            }
//        ) {
//            SignUpScreen(
//                modifier = modifier,
//                navController = navController
//            )
//        }
//
//        composable(
//            route = Screen.GamePopularScreen.route,
//            arguments = listOf(
//                navArgument("difficulty") {
//                    type = NavType.StringType
//                    nullable = true
//                    defaultValue = null
//                },
//                navArgument("type") {
//                    type = NavType.StringType
//                },
//                navArgument("movieId") {
//                    type = NavType.StringType
//                    nullable = true
//                    defaultValue = null
//                },
//                navArgument("seriesId") {
//                    type = NavType.StringType
//                    nullable = true
//                    defaultValue = null
//                }
//            ),
//            enterTransition = {
//                slideInHorizontally(initialOffsetX = { it })
//            },
//            popExitTransition = {
//                slideOutHorizontally(targetOffsetX = { it })
//            }
//        ) {
//            GamePopularScreen(
//                navController = navController
//            )
//        }
    }
}