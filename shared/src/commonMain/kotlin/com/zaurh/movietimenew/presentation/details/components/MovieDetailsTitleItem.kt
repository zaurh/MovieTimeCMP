package com.zaurh.movietimenew.presentation.details.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zaurh.movietimenew.presentation.details.DetailsUIState
import com.zaurh.movietimenew.util.getOutfitFont

@Composable
fun MovieDetailsTitleItem(
    uiState: DetailsUIState
) {
    val releaseDate = uiState.movie?.releaseDate?.take(4).orEmpty()
    val genres = uiState.movie?.genres?.joinToString(", ") { it.name }
    val time = uiState.movie?.runtime.orEmpty()
//    val watchProviders = uiState.watchProviders
//    val context = LocalContext.current

    if (uiState.isLoading.not()) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = uiState.movie?.title.orEmpty(),
            fontSize = 34.sp,
            lineHeight = 34.sp,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.primary,
            fontFamily = getOutfitFont()
        )
        Spacer(Modifier.height(12.dp))

//        LazyRow(
//            modifier = Modifier.fillMaxWidth(),
//            horizontalArrangement = Arrangement.Center
//        ) {
//            items(watchProviders) {
//                it.logoRes?.let { logoRes ->
//                    Image(
//                        modifier = Modifier
//                            .padding(horizontal = 4.dp)
//                            .size(48.dp)
//                            .clip(RoundedCornerShape(10.dp))
//                            .clickable {
//                                val url = it.actionUrl
//
//                                if (url.isBlank()) return@clickable
//
//                                val uri =
//                                    runCatching { url.toUri() }.getOrNull() ?: return@clickable
//
//                                val intent = Intent(Intent.ACTION_VIEW, uri)
//
//                                try {
//                                    context.startActivity(intent)
//                                } catch (e: ActivityNotFoundException) {
//                                    Toast.makeText(
//                                        context,
//                                        "${e.localizedMessage}",
//                                        Toast.LENGTH_SHORT
//                                    )
//                                        .show()
//                                }
//                            },
//                        painter = painterResource(id = logoRes),
//                        contentDescription = null
//                    )
//                }
//            }
//        }

        Spacer(Modifier.height(12.dp))
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "$releaseDate | $time",
            color = MaterialTheme.colorScheme.primary.copy(0.5f),
            textAlign = TextAlign.Center,
            fontFamily = getOutfitFont(),
            fontSize = 14.sp
        )
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = genres.orEmpty(),
            color = MaterialTheme.colorScheme.primary.copy(0.5f),
            textAlign = TextAlign.Center,
            fontFamily = getOutfitFont(),
            fontSize = 14.sp
        )
    } else {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(95.dp)
                .padding(horizontal = 16.dp)
                .clip(RoundedCornerShape(8.dp))
        )
    }
}