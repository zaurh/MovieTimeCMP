package com.zaurh.movietimenew.presentation.tv.components

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
import com.zaurh.movietimenew.domain.models.tv.tv_similar.TvSimilarItem
import com.zaurh.movietimenew.presentation.shared.shimmer
import com.zaurh.movietimenew.util.Constants.EMPTY_IMAGE_URL

@Composable
fun TvSimilar(
    isLoading: Boolean,
    similarSeries: List<TvSimilarItem>,
    onSeriesClick: (Long) -> Unit,
) {
    LazyRow {
        if (isLoading) {
            items(10) {
                SimilarShimmer()
            }
        } else {
            items(similarSeries) { series ->
                AsyncImage(
                    modifier = Modifier
                        .height(200.dp)
                        .width(120.dp)
                        .padding(horizontal = 8.dp)
                        .clip(RoundedCornerShape(5))
                        .clickable {
                            onSeriesClick(series.id)
                        },
                    model = series.posterPath.ifEmpty { EMPTY_IMAGE_URL },
                    contentDescription = null,
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