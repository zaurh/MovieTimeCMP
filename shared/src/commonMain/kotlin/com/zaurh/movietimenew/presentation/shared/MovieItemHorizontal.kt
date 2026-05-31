package com.zaurh.movietimenew.presentation.shared

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.zaurh.movietimenew.presentation.model.MovieUIModel
import com.zaurh.movietimenew.util.Constants.EMPTY_IMAGE_URL
import com.zaurh.movietimenew.util.getOutfitFont

@Composable
fun MovieItemHorizontal(
    movie: MovieUIModel,
    onMovieClick: (Long) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onMovieClick(movie.id) }
            .padding(12.dp)
    ) {
        AsyncImage(
            modifier = Modifier
                .size(100.dp)
                .clip(RoundedCornerShape(10)),
            model = movie.posterPath.ifEmpty { EMPTY_IMAGE_URL },
            contentDescription = null,
            contentScale = ContentScale.Crop
        )

        Spacer(Modifier.size(8.dp))
        Column {
            var overviewExpanded by remember { mutableStateOf(false) }
            Text(
                text = movie.title,
                color = MaterialTheme.colorScheme.primary, fontFamily = getOutfitFont()
            )
            Spacer(Modifier.size(4.dp))
            Text(
                modifier = Modifier.clickable {
                    overviewExpanded = !overviewExpanded
                },
                text = movie.overview,
                maxLines = if (overviewExpanded) Int.MAX_VALUE else 3,
                overflow = TextOverflow.Ellipsis,
                color = MaterialTheme.colorScheme.primary.copy(alpha = 0.5f),
                fontFamily = getOutfitFont()
            )
        }
    }
}