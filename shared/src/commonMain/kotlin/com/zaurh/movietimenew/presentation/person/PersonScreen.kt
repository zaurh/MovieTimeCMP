package com.zaurh.movietimenew.presentation.person

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
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
import com.zaurh.movietimenew.domain.models.person.person_details.PersonDetails
import com.zaurh.movietimenew.domain.models.person.person_movies.PersonMoviesCastItem
import com.zaurh.movietimenew.domain.models.person.person_social_media.PersonSocialMedia
import com.zaurh.movietimenew.domain.models.person.person_tv.PersonTvCastItem
import com.zaurh.movietimenew.presentation.mapper.person.toUIModel
import com.zaurh.movietimenew.presentation.person.components.PersonWallpaperButton
import com.zaurh.movietimenew.presentation.shared.MovieItem
import com.zaurh.movietimenew.presentation.shared.shimmer
import com.zaurh.movietimenew.ui.theme.MovieTimeTheme
import com.zaurh.movietimenew.util.Constants.EMPTY_IMAGE_URL
import com.zaurh.movietimenew.util.getOutfitFont
import movietimenew.shared.generated.resources.Res
import movietimenew.shared.generated.resources.ic_back
import movietimenew.shared.generated.resources.ic_facebook
import movietimenew.shared.generated.resources.ic_instagram
import movietimenew.shared.generated.resources.ic_tiktok
import movietimenew.shared.generated.resources.ic_twitter
import movietimenew.shared.generated.resources.ic_youtube
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun PersonScreen(
    navController: NavController,
    viewModel: PersonViewModel = koinViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
//    val context = LocalContext.current

    LaunchedEffect(Unit) {
        viewModel.sideEffect.collect { effect ->
            when (effect) {
                PersonSideEffect.NavigateToSignIn -> {
//                    navController.navigate(Screen.SignInScreen.route)
                }

                PersonSideEffect.NavigateBack -> {
                    navController.popBackStack()
                }

                is PersonSideEffect.ShowError -> {
//                    Toast.makeText(context, effect.message, Toast.LENGTH_SHORT).show()
                }

                is PersonSideEffect.NavigateToMovie -> {
                    navController.navigate("details_screen/${effect.movieId}")
                }

                is PersonSideEffect.NavigateToTvShows -> {
                    navController.navigate("tv_details_screen/${effect.seriesId}")
                }

                is PersonSideEffect.NavigateToSocialMedia -> {
//                    val uri = Uri.parse(effect.url)
//
//                    val intent = Intent(Intent.ACTION_VIEW, uri).apply {
//                        addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
//                    }
//
//                    context.startActivity(intent)
                }

                is PersonSideEffect.NavigateToWallpapers -> {
                    navController.navigate("wallpaper_screen/${effect.personId}/PERSON")
                }
            }
        }
    }

    PersonContent(
        uiState = uiState, onAction = viewModel::onAction
    )
}

@Composable
fun PersonContent(
    modifier: Modifier = Modifier,
    uiState: PersonUIState,
    onAction: (PersonAction) -> Unit = {},
) {

    BoxWithConstraints(contentAlignment = Alignment.Center) {
        val screenHeight = maxHeight

        Column(
            modifier = modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.surface)
                .verticalScroll(rememberScrollState())
                .navigationBarsPadding()
        ) {
            uiState.person?.let { person ->
                Box(contentAlignment = Alignment.Center) {
                    AsyncImage(
                        modifier = modifier
                            .blur(10.dp)
                            .fillMaxWidth()
                            .height((screenHeight.value / 2).dp),
                        model = person.profilePath.ifEmpty { EMPTY_IMAGE_URL },
                        contentDescription = null,
                        contentScale = ContentScale.Crop
                    )
                    AsyncImage(
                        modifier = modifier
                            .fillMaxWidth()
                            .shimmer(isLoading = uiState.isLoading)
                            .height((screenHeight.value / 2).dp),
                        model = person.profilePath.ifEmpty { EMPTY_IMAGE_URL },
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
                                        Color.Transparent, MaterialTheme.colorScheme.surface
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
                            onAction(PersonAction.OnBackClicked)
                        }) {
                        Icon(
                            painter = painterResource(Res.drawable.ic_back),
                            contentDescription = "",
                            tint = Color.White
                        )
                    }
//                IconButton(
//                    colors = IconButtonDefaults.iconButtonColors(
//                        containerColor = Color.White.copy(alpha = 0.2f)
//                    ),
//                    modifier = modifier
//                        .align(Alignment.TopEnd)
//                        .padding(top = 32.dp, end = 32.dp),
//                    onClick = {
//
//                    }) {
//                    Icon(
//                        imageVector = if (uiState.isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
//                        contentDescription = null,
//                        tint = if (uiState.isFavorite) Color.Red else Color.White
//                    )
//                }
                }

                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = person.name,
                    fontSize = 34.sp,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.primary,
                    fontFamily = getOutfitFont()
                )
                Spacer(Modifier.height(12.dp))

                val birthday = person.birthday
                val deathDay = person.deathday
                val dateText = if (person.deathday.isNotEmpty()) "$birthday - $deathDay" else birthday
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = dateText,
                    color = MaterialTheme.colorScheme.primary.copy(0.5f),
                    textAlign = TextAlign.Center,
                    fontFamily = getOutfitFont()
                )

                Spacer(modifier = Modifier.height(12.dp))
                PersonSocialMediaItems(
                    personSocialMedia = uiState.personSocialMedia, onClick = { url ->
                        onAction(PersonAction.OnSocialMediaClicked(url))
                    })
                if (!uiState.isLoading) {
                    PersonWallpaperButton(onClicked = {
                        onAction(PersonAction.OnWallpapersClicked)
                    })
                }
                if (uiState.personMovies.isNotEmpty()) {
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        modifier = Modifier.padding(horizontal = 8.dp),
                        text = "Movies",
                        color = MaterialTheme.colorScheme.primary,
                        fontFamily = getOutfitFont(),
                        fontWeight = FontWeight.SemiBold
                    )
                    LazyRow {
                        items(uiState.personMovies) { castItem ->
                            MovieItem(
                                movieData = castItem.toUIModel(), onMovieClick = {
                                    onAction(PersonAction.OnMovieClicked(castItem.id))
                                }, posterWidth = 100.dp)
                        }
                    }
                }

                if (uiState.personTvShows.isNotEmpty()) {
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        modifier = Modifier.padding(horizontal = 8.dp),
                        text = "TV Shows",
                        color = MaterialTheme.colorScheme.primary,
                        fontFamily = getOutfitFont(),
                        fontWeight = FontWeight.SemiBold
                    )
                    LazyRow {
                        items(uiState.personTvShows) { castItem ->
                            MovieItem(
                                movieData = castItem.toUIModel(), onMovieClick = {
                                    onAction(PersonAction.OnTvShowClicked(castItem.id))
                                }, posterWidth = 100.dp)
                        }
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    modifier = Modifier.padding(horizontal = 8.dp),
                    text = person.biography.ifEmpty { "No biography" },
                    color = MaterialTheme.colorScheme.primary.copy(0.5f),
                    fontFamily = getOutfitFont()
                )
                Spacer(modifier = Modifier.height(24.dp))
            }
        }
    }
}

@Composable
fun PersonSocialMediaItems(
    personSocialMedia: PersonSocialMedia?, onClick: (String) -> Unit = {}
) {
    personSocialMedia?.let { personSocialMedia ->
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (personSocialMedia.instagramId.isNotEmpty()) {
                PersonSocialMediaIcon(
                    icon = Res.drawable.ic_instagram,
                    onClick = { onClick("https://instagram.com/${personSocialMedia.instagramId}") })
            }

            if (personSocialMedia.tiktokId.isNotEmpty()) {
                PersonSocialMediaIcon(
                    icon = Res.drawable.ic_tiktok,
                    onClick = { onClick("https://tiktok.com/@${personSocialMedia.tiktokId}") })
            }

            if (personSocialMedia.twitterId.isNotEmpty()) {
                PersonSocialMediaIcon(
                    icon = Res.drawable.ic_twitter,
                    onClick = { onClick("https://twitter.com/${personSocialMedia.twitterId}") })
            }

            if (personSocialMedia.facebookId.isNotEmpty()) {
                PersonSocialMediaIcon(
                    icon = Res.drawable.ic_facebook,
                    onClick = { onClick("https://facebook.com/${personSocialMedia.facebookId}") })
            }

            if (personSocialMedia.youtubeId.isNotEmpty()) {
                PersonSocialMediaIcon(
                    icon = Res.drawable.ic_youtube,
                    onClick = { onClick("https://youtube.com/${personSocialMedia.youtubeId}") })
            }
        }
    }

}

@Composable
fun PersonSocialMediaIcon(
    icon: DrawableResource, onClick: () -> Unit
) {
    Image(
        painter = painterResource(icon),
        contentDescription = null,
        modifier = Modifier
            .padding(8.dp)
            .size(40.dp)
            .clip(CircleShape)
            .clickable {
                onClick()
            }
    )
}

@Preview
@Composable
private fun PersonScreenPreview() {
    MovieTimeTheme(darkTheme = true) {
        PersonContent(
            uiState = PersonUIState(
                person = PersonDetails(
                    adult = false,
                    alsoKnownAs = listOf(),
                    biography = "Some biography",
                    profilePath = "",
                    name = "Ryan Gosling",
                    birthday = "1956-07-09"
                ), personMovies = listOf(
                    PersonMoviesCastItem(
                        posterPath = ""
                    )
                ), personSocialMedia = PersonSocialMedia(
                    instagramId = "@ryangosling",
                    tiktokId = "@ryangosling",
                    twitterId = "@ryangosling",
                    facebookId = "@ryangosling",
                    youtubeId = "@ryangosling"
                ),
                personTvShows = listOf(
                    PersonTvCastItem(
                        posterPath = ""
                    )
                )
            )
        )
    }

}