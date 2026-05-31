package com.zaurh.movietimenew.presentation.discover

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.zaurh.movietimenew.presentation.discover.states.DiscoverEvent
import com.zaurh.movietimenew.presentation.discover.states.DiscoverSideEffect
import com.zaurh.movietimenew.presentation.discover.states.DiscoverUIState
import com.zaurh.movietimenew.presentation.model.MovieUIModel
import com.zaurh.movietimenew.presentation.shared.MovieItemHorizontal
import com.zaurh.movietimenew.presentation.shared.PageSwitcher
import com.zaurh.movietimenew.ui.theme.MovieTimeTheme
import com.zaurh.movietimenew.util.getOutfitFont
import movietimenew.shared.generated.resources.Res
import movietimenew.shared.generated.resources.ic_back
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun DiscoverScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: DiscoverViewModel = koinViewModel()
) {
    val uiState = viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.onEvent(DiscoverEvent.OnInit)
    }

    LaunchedEffect(Unit) {
        viewModel.sideEffect.collect { effect ->
            when (effect) {
                is DiscoverSideEffect.NavigateToDetailsScreen -> {
                    navController.navigate("details_screen/${effect.movieId}")
                }

                DiscoverSideEffect.NavigateBack -> {
                    navController.popBackStack()
                }
            }
        }
    }

    DiscoverContent(
        modifier = modifier,
        uiState = uiState.value,
        onEvent = viewModel::onEvent
    )
}

@Composable
fun DiscoverContent(
    modifier: Modifier = Modifier,
    uiState: DiscoverUIState,
    onEvent: (DiscoverEvent) -> Unit = {}
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    val titleCaseName = uiState.genreName.replaceFirstChar {
                        if (it.isLowerCase()) it.titlecase()
                        else it.toString()
                    }
                    Text(
                        text = titleCaseName,
                        fontFamily = getOutfitFont()
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {
                        onEvent(DiscoverEvent.OnNavigateBack)
                    }) {
                        Icon(
                            painter = painterResource(Res.drawable.ic_back),
                            contentDescription = null
                        )
                    }
                }
            )
        },
        content = { paddingValues ->
            LazyColumn(
                modifier = modifier
                    .padding(paddingValues)
                    .background(MaterialTheme.colorScheme.surface)
                    .fillMaxSize()
                    .navigationBarsPadding()
            ) {
                item {
                    PageSwitcher(
                        currentPage = uiState.page,
                        totalPage = uiState.totalPages,
                        onPreviousClick = {
                            onEvent(DiscoverEvent.OnPreviousPageClicked)
                        },
                        onNextClick = {
                            onEvent(DiscoverEvent.OnNextPageClicked)
                        }
                    )
                }
                items(uiState.movies) {
                    MovieItemHorizontal(it) { movieId ->
                        onEvent(DiscoverEvent.OnMovieClicked(movieId))
                    }
                }
            }
        }
    )
}

@Preview
@Composable
private fun DiscoverScreenPreview() {
    MovieTimeTheme {
        DiscoverContent(
            uiState = DiscoverUIState(
                movies = listOf(
                    MovieUIModel(
                        title = "Shrek",
                        overview = "Shrek is green"
                    ),
                    MovieUIModel(
                        title = "Titanic",
                        overview = "Titanic is ship"
                    )
                ),
                totalPages = 100
            )
        )
    }
}