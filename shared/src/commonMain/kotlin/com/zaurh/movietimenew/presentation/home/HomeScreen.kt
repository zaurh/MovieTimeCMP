package com.zaurh.movietimenew.presentation.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.key.Key.Companion.R
import androidx.compose.ui.platform.LocalFocusManager
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.zaurh.movietimenew.presentation.search.SearchScreen
import com.zaurh.movietimenew.presentation.main.MainScreen
import com.zaurh.movietimenew.presentation.navigation.Screen
import com.zaurh.movietimenew.util.getOutfitFont
import kotlinx.coroutines.launch
import movietimenew.shared.generated.resources.Res
import movietimenew.shared.generated.resources.compose_multiplatform
import movietimenew.shared.generated.resources.ic_home
import movietimenew.shared.generated.resources.ic_search
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.getDrawableResourceBytes
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    LaunchedEffect(currentRoute){
        println("currentRoute: $currentRoute")
    }

    val selectedColor = MaterialTheme.colorScheme.primary
    val unselectedColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
    val scope = rememberCoroutineScope()

    val tabItems = listOf(
        TabItem(
            index = 0,
            icon = Res.drawable.ic_home,
            selectedColor = selectedColor,
            unselectedColor = unselectedColor
        ),
        TabItem(
            index = 1,
            icon = Res.drawable.ic_search,
            selectedColor = selectedColor,
            unselectedColor = unselectedColor
        ),
        TabItem(
            index = 2,
            icon = Res.drawable.ic_search,
            selectedColor = selectedColor,
            unselectedColor = unselectedColor
        ),
        TabItem(
            index = 3,
            icon = Res.drawable.ic_search,
            selectedColor = selectedColor,
            unselectedColor = unselectedColor
        ),
        TabItem(
            index = 4,
            icon = Res.drawable.ic_search,
            selectedColor = selectedColor,
            unselectedColor = unselectedColor
        ),
    )

    val pagerState = rememberPagerState(initialPage = 0) { tabItems.size }
    val focusManager = LocalFocusManager.current

    Scaffold(
        containerColor = MaterialTheme.colorScheme.surface,
        contentWindowInsets = WindowInsets(0),
        topBar = {
            when (currentRoute) {
                Screen.HomeScreen.route -> {
                    if (pagerState.currentPage != 1) {
                        focusManager.clearFocus()
                    }
                    when (pagerState.currentPage) {
                        1 -> {
                            TopAppBar(
                                title = {
                                    Text(
                                        text = "Search",
                                        fontFamily = getOutfitFont()
                                    )
                                }
                            )
                        }

                        2 -> {
                            TopAppBar(
                                title = {
                                    Text(
                                        text = "Game",
                                        fontFamily = getOutfitFont()
                                    )
                                }
                            )
                        }

                        3 -> {
                            TopAppBar(
                                title = {
                                    Text(
                                        text = "Favorites",
                                        fontFamily = getOutfitFont()
                                    )
                                }
                            )
                        }

                        4 -> {
                            TopAppBar(
                                title = {
                                    Text(
                                        text = "Profile",
                                        fontFamily = getOutfitFont()
                                    )
                                }
                            )
                        }
                    }
                }

            }
        },
        content = { paddingValues ->
            Box {
                HorizontalPager(
                    state = pagerState,
                    modifier = modifier,
                    pageContent = { index ->
                        when (index) {
                            0 -> MainScreen(
                                navController = navController
                            )

                            1 -> SearchScreen(navController = navController)

                            2 -> {
                                SearchScreen(navController = navController)
//                    GameScreen(navController = navController)
                            }

                            3 -> {
                                SearchScreen(navController = navController)
//                    FavoritesScreen(
//                        navController = navController
//                    )
                            }

                            4 -> {
                                SearchScreen(navController = navController)
//                    ProfileScreen(
//                        navController = navController
//                    )
                            }
                        }
                    }
                )
                if (currentRoute == Screen.HomeScreen.route) {
                    BottomBar(
                        modifier = Modifier.align(Alignment.BottomCenter),
                        tabItems = tabItems,
                        pagerState = pagerState,
                        onItemClick = { index ->
                            scope.launch {
                                pagerState.animateScrollToPage(index)
                            }
                        }
                    )
                }
            }

        }
    )
}

data class TabItem(
    val index: Int,
    val icon: DrawableResource,
    val selectedColor: Color,
    val unselectedColor: Color
)

