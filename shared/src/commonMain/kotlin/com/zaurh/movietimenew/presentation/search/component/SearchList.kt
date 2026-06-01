package com.zaurh.movietimenew.presentation.search.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.zaurh.movietimenew.domain.models.search.multi.SearchMultiItem
import com.zaurh.movietimenew.presentation.search.SearchType
import com.zaurh.movietimenew.util.Constants.EMPTY_IMAGE_URL
import com.zaurh.movietimenew.util.EMPTY
import com.zaurh.movietimenew.util.getOutfitFont
import movietimenew.shared.generated.resources.Res
import movietimenew.shared.generated.resources.ic_movie
import movietimenew.shared.generated.resources.ic_person
import movietimenew.shared.generated.resources.ic_tv
import org.jetbrains.compose.resources.painterResource

@Composable
fun SearchList(
    lazyState: LazyListState,
    multi: List<SearchMultiItem>,
    onMultiClick: (Long, String) -> Unit,
    releaseDateShown: Boolean,
    trendingTextShown: Boolean
) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        state = lazyState,
        contentPadding = PaddingValues(bottom = 64.dp)
    ) {
        item {
            if (trendingTextShown) {
                Text(
                    text = "Trending",
                    fontFamily = getOutfitFont(),
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(12.dp),
                    fontSize = 20.sp
                )
            }
        }
        items(multi) {
            SearchItem(
                multiItem = it,
                onMultiClick = { id, type -> onMultiClick(id, type) },
                releaseDateShown = releaseDateShown
            )
        }
    }
}

@Composable
private fun SearchItem(
    multiItem: SearchMultiItem,
    onMultiClick: (Long, String) -> Unit,
    releaseDateShown: Boolean
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onMultiClick(multiItem.id, multiItem.mediaType) }
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        val imagePath = multiItem.posterPath.ifBlank { multiItem.profilePath }

        AsyncImage(
            modifier = Modifier
                .size(100.dp)
                .clip(RoundedCornerShape(10)),
            model = imagePath.ifEmpty { EMPTY_IMAGE_URL },
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Spacer(Modifier.size(8.dp))
        Column {
            val title = multiItem.title.ifBlank { multiItem.name }
            val releaseDate = multiItem.releaseDate.take(4)
            val releaseDateText = if (releaseDate.isNotEmpty()) "($releaseDate)" else EMPTY

            val titleText = if (releaseDateShown) "$title $releaseDateText" else title
            val typeColor = when (multiItem.mediaType) {
                SearchType.MOVIE.typeName -> Color.Blue
                SearchType.PERSON.typeName -> Color.Green
                else -> Color.Yellow
            }
            val mediaTypeText = when (multiItem.mediaType) {
                SearchType.MOVIE.typeName -> SearchType.MOVIE.displayName
                SearchType.PERSON.typeName -> SearchType.PERSON.displayName
                else -> SearchType.TV.displayName
            }
            val mediaTypeIcon = when (multiItem.mediaType) {
                SearchType.MOVIE.typeName -> Res.drawable.ic_movie
                SearchType.PERSON.typeName -> Res.drawable.ic_person
                else -> Res.drawable.ic_tv
            }

            Text(
                text = titleText,
                color = MaterialTheme.colorScheme.primary,
                fontFamily = getOutfitFont(),
                fontWeight = FontWeight.SemiBold
            )
            Row(
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .background(typeColor)
                    .padding(horizontal = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(mediaTypeIcon),
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(16.dp)
                )
                Spacer(Modifier.width(4.dp))
                Text(
                    text = mediaTypeText,
                    color = Color.White,
                    fontFamily = getOutfitFont(),
                    fontSize = 12.sp
                )
            }

            if (multiItem.overview.isNotEmpty()) {
                Spacer(Modifier.size(4.dp))
                Text(
                    text = multiItem.overview,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis,
                    color = MaterialTheme.colorScheme.primary.copy(alpha = 0.5f),
                    fontFamily = getOutfitFont()
                )
            }
        }
    }
}