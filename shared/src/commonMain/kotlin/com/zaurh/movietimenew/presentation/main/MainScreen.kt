package com.zaurh.movietimenew.presentation.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LifecycleEventEffect
import androidx.navigation.NavController
import com.zaurh.movietimenew.presentation.main.components.UpcomingMovieItem
import com.zaurh.movietimenew.presentation.main.components.MainMovieComponent
import com.zaurh.movietimenew.presentation.mapper.movie.toUIModel
import com.zaurh.movietimenew.presentation.shared.shimmer
import com.zaurh.movietimenew.util.ZERO
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import org.koin.compose.koinInject

@Composable
fun MainScreen(
    viewModel: MainViewModel = koinInject(),
    navController: NavController
) {
    val uiState = viewModel.uiState.collectAsState()
    val upcomingMovies = uiState.value.upcomingMovies
    val popularMovies = uiState.value.popularMovies
    val nowPlayingMovies = uiState.value.nowPlayingMovies
    val topRatedMovies = uiState.value.topRatedMovies


    LaunchedEffect(Unit) {
        viewModel.onEvent(MainEvent.OnInit)
    }

    LaunchedEffect(Unit) {
        viewModel.sideEffect.collect { effect ->
            when (effect) {
                is MainSideEffect.NavigateToDetailsScreen -> {
                    navController.navigate("details_screen/${effect.movieId}")
                }

                is MainSideEffect.NavigateToDiscoverScreen -> {
                    navController.navigate("discover_screen/${effect.genreName}/${effect.genreId}")
                }
            }
        }
    }

    val pagerState =
        rememberPagerState(
            initialPage = ZERO,
            pageCount = { upcomingMovies.size })

    var scrollJob: Job? by remember { mutableStateOf(null) }
    val scope = rememberCoroutineScope()

    LifecycleEventEffect(event = Lifecycle.Event.ON_RESUME) {
        scrollJob?.cancel()
        scrollJob = scope.launch {
            while (isActive) {
                delay(10000)
                val nextPage = if (pagerState.canScrollForward) {
                    pagerState.currentPage + 1
                } else {
                    ZERO
                }
                pagerState.animateScrollToPage(nextPage)
            }
        }
    }

    LifecycleEventEffect(event = Lifecycle.Event.ON_PAUSE) {
        scrollJob?.cancel()
    }

    BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
        val screenHeight = maxHeight

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .background(MaterialTheme.colorScheme.surface),
            horizontalAlignment = Alignment.Start
        ) {
            Box(contentAlignment = Alignment.Center) {
                HorizontalPager(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height((screenHeight.value * 0.6).dp)
                        .shimmer(isLoading = uiState.value.isLoading),
                    state = pagerState,
                ) { page ->
                    val movie = upcomingMovies.getOrNull(page)
                    movie?.let {
                        UpcomingMovieItem(it) { movieId ->
                            viewModel.onEvent(MainEvent.OnMovieClicked(movieId))
                        }
                    }
                }
                Row(
                    Modifier
                        .height(50.dp)
                        .fillMaxWidth()
                        .align(Alignment.BottomCenter),
                    horizontalArrangement = Arrangement.Center
                ) {
                    repeat(pagerState.pageCount) { iteration ->
                        val color =
                            if (pagerState.currentPage == iteration) Color.DarkGray else Color.LightGray
                        Box(
                            modifier = Modifier
                                .padding(4.dp)
                                .background(color, CircleShape)
                                .size(5.dp)
                        )
                    }
                }
            }

            Text(
                text = "Genres",
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(12.dp),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )

            MainMovieComponent("Popular", popularMovies.map { it.toUIModel() }, viewModel)
            MainMovieComponent("Now playing", nowPlayingMovies.map { it.toUIModel() }, viewModel)
            MainMovieComponent("Top rated", topRatedMovies.map { it.toUIModel() }, viewModel)

            Spacer(Modifier.height(64.dp))
        }
    }
}