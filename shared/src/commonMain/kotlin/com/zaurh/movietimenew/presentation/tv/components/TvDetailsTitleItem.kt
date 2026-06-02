package com.zaurh.movietimenew.presentation.tv.components

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
import com.zaurh.movietimenew.presentation.tv.TvDetailsUIState
import com.zaurh.movietimenew.util.getOutfitFont

@Composable
fun TvDetailsTitleItem(
    uiState: TvDetailsUIState
) {
    val firstAirDate = uiState.tvDetails?.firstAirDate.orEmpty()
    val lastAirDate = uiState.tvDetails?.lastAirDate.orEmpty()
//    val context = LocalContext.current

    val genres = uiState.tvDetails?.genres?.joinToString(", ") { it.name }

    if (uiState.isLoading.not()) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = uiState.tvDetails?.title.orEmpty(),
            fontSize = 34.sp,
            lineHeight = 34.sp,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.primary,
            fontFamily = getOutfitFont()
        )
//        Spacer(Modifier.height(12.dp))

//        LazyRow(
//            modifier = Modifier.fillMaxWidth(),
//            horizontalArrangement = Arrangement.Center
//        ) {
//            items(uiState.watchProviders) {
//                it.logoRes?.let { logoRes ->
//                    Image(
//                        modifier = Modifier
//                            .padding(horizontal = 4.dp)
//                            .size(48.dp)
//                            .clip(RoundedCornerShape(10.dp))
//                            .clickable {
////                                it.actionUrl.let { url ->
////                                    val intent = Intent(Intent.ACTION_VIEW, url.toUri())
////                                    context.startActivity(intent)
////                                }
//                            },
//                        painter = painterResource(id = logoRes),
//                        contentDescription = null
//                    )
//                }
//            }
//        }
        Spacer(Modifier.height(12.dp))
        val airDateText =
            if (lastAirDate.isNotEmpty()) "$firstAirDate | $lastAirDate" else firstAirDate
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = airDateText,
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