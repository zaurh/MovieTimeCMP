package com.zaurh.movietimenew.presentation.details.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.zaurh.movietimenew.domain.models.movie.movie_recommendations.MovieRecommendationsItem
import com.zaurh.movietimenew.presentation.shared.shimmer

@Composable
fun Similar(
    isLoading: Boolean,
    recommendedMovies: List<MovieRecommendationsItem>,
    onMovieClick: (Long) -> Unit,
) {
    BoxWithConstraints {

        val posterWidth = when {
            maxWidth < 600.dp -> 100.dp
            maxWidth < 900.dp -> 140.dp
            else -> 200.dp
        }

        val posterHeight = posterWidth * 1.5f

        LazyRow {
            if (isLoading) {
                items(20) {
                    Box(
                        modifier = Modifier
                            .height(posterHeight)
                            .width(posterWidth)
                            .padding(horizontal = 8.dp)
                            .clip(RoundedCornerShape(5))
                            .shimmer()
                    )
                }
            } else {
                items(recommendedMovies) { movie ->
                    AsyncImage(
                        modifier = Modifier
                            .padding(horizontal = 8.dp)
                            .width(posterWidth)
                            .height(posterHeight)
                            .clip(RoundedCornerShape(5))
                            .clickable {
                                onMovieClick(movie.id)
                            },
                        model = movie.posterPath,
                        contentDescription = "",
                        contentScale = ContentScale.Crop
                    )
                }
            }
        }
    }
}