package com.zaurh.movietimenew.presentation.shared

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.zaurh.movietimenew.presentation.model.MovieUIModel
import com.zaurh.movietimenew.util.Constants.EMPTY_IMAGE_URL

@Composable
fun MovieItem(
    movieData: MovieUIModel,
    posterWidth: Dp,
    onMovieClick: (Long) -> Unit
) {
    Box(
        modifier = Modifier
            .padding(8.dp)
            .clip(RoundedCornerShape(10))
            .clickable { onMovieClick(movieData.id) }
    ) {
        AsyncImage(
            modifier = Modifier
                .width(posterWidth)
                .aspectRatio(2f / 3f),
            model = movieData.posterPath.ifEmpty { EMPTY_IMAGE_URL },
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
    }
}