package com.zaurh.movietimenew.presentation.details.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.zaurh.movietimenew.domain.models.movie.movie_credits.MovieCreditsCast
import com.zaurh.movietimenew.util.Constants.EMPTY_IMAGE_URL
import com.zaurh.movietimenew.util.getOutfitFont

@Composable
fun CastItem(
    cast: MovieCreditsCast,
    cardWidth: Dp,
    avatarSize: Dp,
    onClick: (Long) -> Unit = {}
) {
    Column(
        modifier = Modifier
            .width(cardWidth)
            .padding(8.dp)
            .clickable { onClick(cast.id) },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        AsyncImage(
            modifier = Modifier
                .size(avatarSize)
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