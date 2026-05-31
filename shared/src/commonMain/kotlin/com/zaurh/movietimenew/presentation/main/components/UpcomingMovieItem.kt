package com.zaurh.movietimenew.presentation.main.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.zaurh.movietimenew.domain.models.movie.movie_upcoming.UpcomingMoviesItem

@Composable
fun UpcomingMovieItem(
    movieData: UpcomingMoviesItem,
    onMovieClick: (movieId: Long) -> Unit
) {
    Box(modifier = Modifier.fillMaxSize().clickable {
        onMovieClick(movieData.id)
    }) {
        AsyncImage(
            modifier = Modifier.fillMaxSize().blur(10.dp),
            model = movieData.posterPath,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        AsyncImage(
            modifier = Modifier.fillMaxSize(),
            model = movieData.posterPath,
            contentDescription = null,
            contentScale = ContentScale.FillHeight
        )

    }
}