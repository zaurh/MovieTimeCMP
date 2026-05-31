package com.zaurh.movietimenew.presentation.details

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
import androidx.compose.ui.draw.blur
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
import com.zaurh.movietimenew.domain.models.movie.movie_credits.MovieCreditsCast
import com.zaurh.movietimenew.domain.models.movie.movie_details.MovieDetailsGenre
import com.zaurh.movietimenew.presentation.details.components.CastRow
import com.zaurh.movietimenew.presentation.details.components.MovieDetailsActionButton
import com.zaurh.movietimenew.presentation.details.components.MovieDetailsReviewButton
import com.zaurh.movietimenew.presentation.details.components.MovieDetailsTitleItem
import com.zaurh.movietimenew.presentation.details.components.Similar
import com.zaurh.movietimenew.presentation.details.components.bottomsheet.MovieDetailsGameBottomSheet
import com.zaurh.movietimenew.presentation.model.MovieDetailsUIModel
import com.zaurh.movietimenew.presentation.navigation.Screen
import com.zaurh.movietimenew.presentation.shared.shimmer
import com.zaurh.movietimenew.ui.theme.MovieTimeTheme
import com.zaurh.movietimenew.util.Constants.EMPTY_IMAGE_URL
import com.zaurh.movietimenew.util.EMPTY
import com.zaurh.movietimenew.util.getOutfitFont
import movietimenew.shared.generated.resources.Res
import movietimenew.shared.generated.resources.ic_gallery
import movietimenew.shared.generated.resources.ic_gamepad
import org.koin.compose.koinInject
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun DetailScreen(
    modifier: Modifier,
    navController: NavController,
    viewModel: MovieDetailsViewModel = koinViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
//    val context = LocalContext.current

    LaunchedEffect(Unit) {
        viewModel.sideEffect.collect { effect ->
            when (effect) {
                DetailsSideEffect.NavigateToSignIn -> {
                    navController.navigate(Screen.SignInScreen.route)
                }

                DetailsSideEffect.NavigateBack -> {
                    navController.popBackStack()
                }

                is DetailsSideEffect.ShowError -> {
//                    Toast.makeText(context, effect.message, Toast.LENGTH_SHORT).show()
                }

                is DetailsSideEffect.NavigateToCast -> {
                    navController.navigate("person_screen/${effect.castId}")
                }

                is DetailsSideEffect.NavigateToWallpapers -> {
                    navController.navigate("wallpaper_screen/${effect.movieId}/MOVIE")
                }

                is DetailsSideEffect.NavigateToGamePopularScreen -> {
                    navController.navigate("game_popular_screen?difficulty=&type=${effect.gameMode}&movieId=${effect.movieId}")
                }
            }
        }
    }

//    MovieDetailsReviewAlert(
//        enabled = uiState.reviewAlert,
//        reviewValue = uiState.reviewValue,
//        rate = uiState.selectedReviewRate,
//        onReviewValueChange = {
//            viewModel.onAction(DetailsAction.OnReviewValueChange(it))
//        },
//        onDismiss = {
//            viewModel.onAction(DetailsAction.OnReviewAlertClosed)
//        },
//        onThumbClick = {
//            viewModel.onAction(DetailsAction.OnReviewRateSelected(it))
//        },
//        onSend = {
//            viewModel.onAction(DetailsAction.OnAddReview)
//        },
//        isLoading = uiState.isLoading
//    )

    DetailContent(
        modifier = modifier,
        uiState = uiState,
        onAction = viewModel::onAction
    )
}

@Composable
fun DetailContent(
    modifier: Modifier = Modifier,
    uiState: DetailsUIState,
    onAction: (DetailsAction) -> Unit = {},
) {
//    val configuration = LocalConfiguration.current
//    val screenHeight = configuration.screenHeightDp
//    val context = LocalContext.current

    BoxWithConstraints(contentAlignment = Alignment.Center) {
        val screenHeight = maxHeight
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.surface)
                .verticalScroll(rememberScrollState())
                .navigationBarsPadding()
        ) {
            Box {
                AsyncImage(
                    modifier = modifier
                        .blur(10.dp)
                        .fillMaxWidth()
                        .height((screenHeight.value * 0.5).dp),
                    model = uiState.movie?.posterPath?.ifEmpty { EMPTY_IMAGE_URL },
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
                AsyncImage(
                    modifier = modifier
                        .fillMaxWidth()
                        .shimmer(isLoading = uiState.isLoading)
                        .height((screenHeight.value * 0.5).dp),
                    model = uiState.movie?.posterPath?.ifEmpty { EMPTY_IMAGE_URL },
                    contentDescription = null,
                    contentScale = ContentScale.FillHeight
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
                        onAction(DetailsAction.OnBackClicked)
                    }) {
//                Icon(
//                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
//                    contentDescription = "",
//                    tint = Color.White
//                )
                }
                IconButton(
                    colors = IconButtonDefaults.iconButtonColors(
                        containerColor = Color.White.copy(alpha = 0.2f)
                    ),
                    modifier = modifier
                        .align(Alignment.TopEnd)
                        .padding(top = 32.dp, end = 32.dp),
                    onClick = {
                        onAction(DetailsAction.ToggleFavorite)
                    }) {
//                Icon(
//                    imageVector = if (uiState.isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
//                    contentDescription = null,
//                    tint = if (uiState.isFavorite) Color.Red else Color.White
//                )
                }
            }


            MovieDetailsTitleItem(uiState)
            if (!uiState.isLoading) {
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                    MovieDetailsActionButton(
                        icon = Res.drawable.ic_gallery
                    ) {
                        onAction(DetailsAction.OnWallpapersClicked)
                    }
                    if (uiState.credits.any { it.profilePath.isNotEmpty() }) {
                        MovieDetailsActionButton(
                            icon = Res.drawable.ic_gamepad
                        ) {
                            onAction(DetailsAction.OnGameClicked)
                        }
                    }
                }
            }
//        Spacer(Modifier.height(16.dp))
//        Trailer(trailerVideoKey = uiState.trailerKey)
            Spacer(modifier = Modifier.height(16.dp))
            Similar(
                isLoading = uiState.isLoading,
                recommendedMovies = uiState.recommendations,
                onMovieClick = { movieId ->
                    onAction(DetailsAction.OnMovieClick(movieId))
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
                text = uiState.movie?.overview?.ifEmpty { "No description" }
                    .orEmpty(),
                color = MaterialTheme.colorScheme.primary.copy(0.5f),
                fontFamily = getOutfitFont()
            )
            Spacer(modifier = Modifier.height(24.dp))

            CastRow(uiState, onAction)

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
//            Text(
//                text = "Reviews (${uiState.allReviews.size})",
//                fontSize = 22.sp,
//                fontWeight = FontWeight.Bold,
//                color = MaterialTheme.colorScheme.primary,
//                fontFamily = getOutfitFont()
//            )
                if (uiState.userData != null) {
                    MovieDetailsReviewButton("Add review") {
                        onAction(DetailsAction.OnAddReviewClicked)
                    }
                } else {
                    MovieDetailsReviewButton("Sign in to review") {
                        onAction(DetailsAction.OnSignInClicked)
                    }
                }
            }
//
//        Reviews(
//            reviews = uiState.allReviews,
//            errorMessage = uiState.reviewError?.asString(context).orEmpty()
//        )
        }
    }
    MovieDetailsGameBottomSheet(uiState, onAction)
}

@Preview
@Composable
private fun DetailScreenPreview() {
    MovieTimeTheme {
        DetailContent(
            uiState = DetailsUIState(
                movie = MovieDetailsUIModel(
                    title = "Shrek",
                    overview = "Shrek is green",
                    releaseDate = "2023",
                    runtime = "1h 30m",
                    genres = listOf(
                        MovieDetailsGenre(
                            name = "Animation"
                        ),
                        MovieDetailsGenre(
                            name = "Comedy"
                        )
                    )
                ),
                credits = listOf(
                    MovieCreditsCast(
                        name = "Brad Pitt",
                        character = "Tyler Durden",
                        gender = 2,
                        profilePath = ""
                    ),
                    MovieCreditsCast(
                        name = "Angelina Jolie",
                        character = "Angelina",
                        gender = 1,
                        profilePath = ""
                    )
                ),
//                watchProviders = listOf(
//                    ProviderUIModel(
//                        logoRes = R.drawable.logo_netflix,
//                    ),
//                    ProviderUIModel(
//                        logoRes = R.drawable.logo_disney
//                    ),
//                    ProviderUIModel(
//                        logoRes = R.drawable.logo_hbomax
//                    ),
//                    ProviderUIModel(
//                        logoRes = R.drawable.logo_youtube
//                    ),
//                    ProviderUIModel(
//                        logoRes = R.drawable.logo_prime
//                    ),
//                    ProviderUIModel(
//                        logoRes = R.drawable.logo_paramount
//                    )
//                ),
                trailerKey = "trailer"
            )
        )
    }
}