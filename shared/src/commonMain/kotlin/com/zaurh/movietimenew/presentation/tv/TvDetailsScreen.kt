package com.zaurh.movietimenew.presentation.tv

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import com.zaurh.movieappintern2.presentation.tv.TvDetailsViewModel
import com.zaurh.movietimenew.domain.models.tv.tv_credits.TvCreditsCast
import com.zaurh.movietimenew.presentation.model.TvDetailsUIModel
import com.zaurh.movietimenew.presentation.shared.shimmer
import com.zaurh.movietimenew.presentation.tv.components.TvDetailsActionButton
import com.zaurh.movietimenew.presentation.tv.components.TvDetailsTitleItem
import com.zaurh.movietimenew.presentation.tv.components.TvSimilar
import com.zaurh.movietimenew.presentation.tv.components.bottomsheet.TvDetailsGameBottomSheet
import com.zaurh.movietimenew.ui.theme.MovieTimeTheme
import com.zaurh.movietimenew.util.Constants.EMPTY_IMAGE_URL
import com.zaurh.movietimenew.util.EMPTY
import com.zaurh.movietimenew.util.getOutfitFont
import movietimenew.shared.generated.resources.Res
import movietimenew.shared.generated.resources.ic_back
import movietimenew.shared.generated.resources.ic_gallery
import movietimenew.shared.generated.resources.ic_gamepad
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun TvDetailsScreen(
    navController: NavController,
    viewModel: TvDetailsViewModel = koinViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
//    val context = LocalContext.current

    LaunchedEffect(Unit) {
        viewModel.onEvent(TvDetailsAction.OnInit)
    }

    LaunchedEffect(Unit) {
        viewModel.sideEffect.collect { effect ->
            when (effect) {
                TvDetailsSideEffect.NavigateToSignIn -> {
//                    navController.navigate(Screen.SignInScreen.route)
                }

                TvDetailsSideEffect.NavigateBack -> {
                    navController.popBackStack()
                }

                is TvDetailsSideEffect.ShowError -> {
//                    Toast.makeText(context, effect.message, Toast.LENGTH_SHORT).show()
                }

                is TvDetailsSideEffect.NavigateToCast -> {
                    navController.navigate("person_screen/${effect.castId}")
                }

                is TvDetailsSideEffect.NavigateToWallpapers -> {
                    navController.navigate("wallpaper_screen/${effect.seriesId}/TV")
                }

                is TvDetailsSideEffect.NavigateToGamePopularScreen -> {
                    navController.navigate("game_popular_screen?difficulty=&type=${effect.gameMode}&seriesId=${effect.seriesId}")
                }
            }
        }
    }

//    TvReviewAlert(
//        enabled = uiState.reviewAlert,
//        reviewValue = uiState.reviewValue,
//        rate = uiState.selectedReviewRate,
//        onReviewValueChange = {
//            viewModel.onEvent(TvDetailsAction.OnReviewValueChange(it))
//        },
//        onDismiss = {
//            viewModel.onEvent(TvDetailsAction.OnReviewAlertClosed)
//        },
//        onThumbClick = {
//            viewModel.onEvent(TvDetailsAction.OnReviewRateSelected(it))
//        },
//        onSend = {
//            viewModel.onEvent(TvDetailsAction.OnAddReview)
//        },
//        isLoading = uiState.isLoading
//    )

    TvContent(
        uiState = uiState,
        onEvent = viewModel::onEvent
    )
}

@Composable
fun TvContent(
    modifier: Modifier = Modifier,
    uiState: TvDetailsUIState,
    onEvent: (TvDetailsAction) -> Unit = {},
) {
//    val configuration = LocalConfiguration.current
//    val screenHeight = configuration.screenHeightDp

    BoxWithConstraints(contentAlignment = Alignment.Center) {
        val screenHeight = maxHeight
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.surface)
                .verticalScroll(rememberScrollState())
                .navigationBarsPadding()
        ) {
            Box(contentAlignment = Alignment.Center) {
                AsyncImage(
                    modifier = modifier
                        .fillMaxWidth()
                        .shimmer(isLoading = uiState.isLoading)
                        .height((screenHeight.value / 2).dp),
                    model = uiState.tvDetails?.posterPath?.ifEmpty { EMPTY_IMAGE_URL },
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
                Box(
                    modifier = modifier
                        .fillMaxWidth()
                        .height((screenHeight.value / 10).dp)
                        .align(Alignment.BottomCenter)
                        .background(
                            brush = Brush.verticalGradient(
                                listOf(
                                    Color.Transparent,
                                    MaterialTheme.colorScheme.surface
                                )
                            )
                        )
                )
                IconButton(
                    colors = IconButtonDefaults.iconButtonColors(
                        containerColor = Color.White.copy(alpha = 0.2f)
                    ),
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(top = 32.dp, start = 32.dp),
                    onClick = {
                        onEvent(TvDetailsAction.OnBackClicked)
                    }) {
                    Icon(
                        painter = painterResource(Res.drawable.ic_back),
                        contentDescription = null,
                        tint = Color.White
                    )
                }
//            IconButton(
//                colors = IconButtonDefaults.iconButtonColors(
//                    containerColor = Color.White.copy(alpha = 0.2f)
//                ),
//                modifier = modifier
//                    .align(Alignment.TopEnd)
//                    .padding(top = 32.dp, end = 32.dp),
//                onClick = {
//                    onEvent(TvDetailsAction.ToggleFavorite)
//                }) {
//                Icon(
//                    imageVector = if (uiState.isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
//                    contentDescription = null,
//                    tint = if (uiState.isFavorite) Color.Red else Color.White
//                )
//            }
            }


            TvDetailsTitleItem(uiState)
            if (!uiState.isLoading) {
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                    TvDetailsActionButton(
                        icon = Res.drawable.ic_gallery
                    ) {
                        onEvent(TvDetailsAction.OnWallpapersClicked)
                    }
                    if (uiState.credits.any { it.profilePath.isNotEmpty() }) {
                        TvDetailsActionButton(
                            icon = Res.drawable.ic_gamepad
                        ) {
                            onEvent(TvDetailsAction.OnGameClicked)
                        }
                    }
                }
            }
//        TvTrailer(trailerVideoKey = uiState.trailerKey)
            Spacer(modifier = Modifier.height(16.dp))
            TvSimilar(
                isLoading = uiState.isLoading,
                similarSeries = uiState.similar,
                onSeriesClick = { tvSeriesId ->
                    onEvent(TvDetailsAction.OnTvSeriesClicked(tvSeriesId))
                }
            )
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                modifier = Modifier.padding(horizontal = 8.dp),
                text = if (uiState.isLoading.not()) "Description" else EMPTY,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary,
                fontFamily = getOutfitFont()
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                modifier = Modifier.padding(horizontal = 8.dp),
                text = uiState.tvDetails?.overview?.ifEmpty { "No description" }
                    .orEmpty(),
                color = MaterialTheme.colorScheme.primary.copy(0.5f),
                fontFamily = getOutfitFont()
            )
            Spacer(modifier = Modifier.height(24.dp))

            LazyRow {
                items(uiState.credits) {
                    CastItem(cast = it, onClick = { id ->
                        onEvent(TvDetailsAction.OnCastClick(id))
                    })
                }
            }
        }

//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(horizontal = 8.dp),
//            horizontalArrangement = Arrangement.SpaceBetween,
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            Text(
//                text = "Reviews (${uiState.allReviews.size})",
//                fontSize = 22.sp,
//                fontWeight = FontWeight.Bold,
//                color = MaterialTheme.colorScheme.primary,
//                fontFamily = outfitFamily
//            )
//            if (uiState.userData != null) {
//                TvReviewButton("Add review") {
//                    onEvent(TvDetailsAction.OnAddReviewClicked)
//                }
//            } else {
//                TvReviewButton("Sign in review") {
//                    onEvent(TvDetailsAction.OnSignInClicked)
//                }
//            }
//        }
//
//        TvReviews(
//            reviews = uiState.allReviews,
//            errorMessage = uiState.reviewError
//        )
    }

    TvDetailsGameBottomSheet(uiState, onEvent)
}

@Composable
fun CastItem(
    cast: TvCreditsCast,
    onClick: (Long) -> Unit = {}
) {
    Column(
        modifier = Modifier
            .height(200.dp)
            .width(140.dp)
            .clickable {
                onClick(cast.id)
            }, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            modifier = Modifier
                .padding(8.dp)
                .size(80.dp)
                .clip(CircleShape),
            model = cast.profilePath.ifEmpty { EMPTY_IMAGE_URL },
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Text(
            text = cast.character,
            fontSize = 16.sp,
            color = MaterialTheme.colorScheme.primary,
            fontFamily = getOutfitFont(),
            textAlign = TextAlign.Center
        )
        Text(
            text = cast.name,
            fontSize = 12.sp,
            color = MaterialTheme.colorScheme.secondary,
            fontFamily = getOutfitFont(),
            textAlign = TextAlign.Center
        )
    }
}

@Preview
@Composable
private fun TvScreenPreview() {
    MovieTimeTheme {
        TvContent(
            uiState = TvDetailsUIState(
                tvDetails = TvDetailsUIModel(
                    title = "Shrek",
                    overview = "Shrek is green",
                    firstAirDate = "2023"
                ),
                credits = listOf(
                    TvCreditsCast(
                        name = "Brad Pitt",
                        character = "Tyler Durden",
                        gender = 2,
                        profilePath = ""
                    ),
                    TvCreditsCast(
                        name = "Angelina Jolie",
                        character = "Angelina",
                        gender = 1,
                        profilePath = ""
                    )
                ),
                trailerKey = "key"
            )
        )
    }
}