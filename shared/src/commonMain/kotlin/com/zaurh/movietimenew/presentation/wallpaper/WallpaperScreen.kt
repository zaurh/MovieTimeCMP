package com.zaurh.movietimenew.presentation.wallpaper

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.animateScrollBy
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import coil3.compose.SubcomposeAsyncImage
import com.zaurh.movietimenew.presentation.wallpaper.bottomsheet.WallpaperMoreBottomSheet
import com.zaurh.movietimenew.ui.theme.MovieTimeTheme
import com.zaurh.movietimenew.util.ZERO
import kotlinx.coroutines.delay
import movietimenew.shared.generated.resources.Res
import movietimenew.shared.generated.resources.ic_back
import movietimenew.shared.generated.resources.ic_download
import movietimenew.shared.generated.resources.ic_more
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun WallpaperScreen(
    navController: NavController,
    viewModel: WallpaperViewModel = koinViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
//    val context = LocalContext.current
    val pagerState = rememberPagerState(
        initialPage = ZERO,
        pageCount = { uiState.images.size })
//    val downloadSuccessText = stringResource(R.string.wallpaper_download_success)
//    val wallpaperSetSuccessText = stringResource(R.string.wallpaper_wallpaper_success)

    LaunchedEffect(uiState.images) {
        if (uiState.images.size > 1 && uiState.wallpaperSeen == false) {
            delay(500)
            pagerState.animateScrollBy(300f)
            delay(1000)
            pagerState.animateScrollBy(-300f)
            delay(1000)
            viewModel.onAction(WallpaperAction.OnWallpaperSeen)
        }
    }

    LaunchedEffect(Unit) {
        viewModel.sideEffect.collect { effect ->
            when (effect) {
                WallpaperSideEffect.NavigateBack -> {
                    navController.popBackStack()
                }

                is WallpaperSideEffect.DownloadImage -> {
//                    val imageUrl = uiState.images
//                        .getOrNull(pagerState.currentPage)
//                        ?.filePath ?: return@collect
//
//                    context.downloadImage(imageUrl = imageUrl).onSuccess {
//                        Toast.makeText(context, downloadSuccessText, Toast.LENGTH_SHORT)
//                            .show()
//                    }.onError { _, message ->
//                        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
//                    }
                }

                WallpaperSideEffect.SetAsWallpaper -> {
                    val imageUrl = uiState.images
                        .getOrNull(pagerState.currentPage)
                        ?.filePath ?: return@collect
//
//                    context.setWallpaper(imageUrl = imageUrl).onSuccess {
//                        Toast.makeText(context, wallpaperSetSuccessText, Toast.LENGTH_SHORT)
//                            .show()
//                    }.onError { _, message ->
//                        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
//                    }
                }
            }
        }
    }
    WallpaperContent(
        pagerState = pagerState,
        uiState = uiState,
        onAction = viewModel::onAction
    )

    WallpaperMoreBottomSheet(uiState = uiState, onAction = viewModel::onAction)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WallpaperContent(
    pagerState: PagerState,
    uiState: WallpaperUIState,
    onAction: (WallpaperAction) -> Unit = {}
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {},
                navigationIcon = {
                    IconButton(onClick = {
                        onAction(WallpaperAction.OnBackClicked)
                    }) {
                        Icon(
                            painter = painterResource(Res.drawable.ic_back),
                            contentDescription = null
                        )
                    }
                },
                actions = {
                    IconButton(onClick = {
                        onAction(WallpaperAction.OnDownloadClicked)
                    }) {
                        Icon(
                            painter = painterResource(Res.drawable.ic_download),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp),
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                    IconButton(onClick = {
                        onAction(WallpaperAction.OnMoreClicked)
                    }) {
                        Icon(
                            painter = painterResource(Res.drawable.ic_more),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }
            )
        },
        content = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.surface)
                    .navigationBarsPadding()
            ) {
                HorizontalPager(
                    modifier = Modifier
                        .fillMaxSize(),
                    state = pagerState
                ) { page ->
                    val images = uiState.images.getOrNull(page)

                    images?.let {
                        SubcomposeAsyncImage(
                            modifier = Modifier.fillMaxSize(),
                            model = it.filePath,
                            contentDescription = null,
                            contentScale = ContentScale.Fit,
                            loading = {
                                Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                                    CircularProgressIndicator(
                                        modifier = Modifier.size(36.dp),
                                        color = MaterialTheme.colorScheme.primary
                                    )
                                }
                            }
                        )
                    }
                }
            }
        }
    )
}

@Preview
@Composable
private fun WallpaperScreenPreview() {
    MovieTimeTheme {
        WallpaperContent(
            uiState = WallpaperUIState(),
            pagerState = rememberPagerState(0, pageCount = { 0 })
        )
    }
}