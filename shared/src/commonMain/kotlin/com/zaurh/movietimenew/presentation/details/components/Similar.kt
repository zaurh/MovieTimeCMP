package com.zaurh.movietimenew.presentation.details.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
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
    LazyRow {
        if (isLoading) {
            items(10) {
                SimilarShimmer()
            }
        } else {
            items(recommendedMovies) { movie ->
                AsyncImage(
                    modifier = Modifier
                        .height(200.dp)
                        .width(120.dp)
                        .padding(horizontal = 8.dp)
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

@Composable
private fun SimilarShimmer() {
    Box(
        modifier = Modifier
            .height(200.dp)
            .width(120.dp)
            .padding(horizontal = 8.dp)
            .clip(RoundedCornerShape(5))
            .shimmer()
    )
}