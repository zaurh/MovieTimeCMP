package com.zaurh.movietimenew.presentation.details.components

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.zaurh.movietimenew.presentation.details.DetailsAction
import com.zaurh.movietimenew.presentation.details.DetailsUIState

@Composable
fun CastRow(
    uiState: DetailsUIState,
    onAction: (DetailsAction) -> Unit = {},
) {
    BoxWithConstraints {

        val cardWidth = when {
            maxWidth < 600.dp -> 100.dp
            maxWidth < 900.dp -> 140.dp
            else -> 180.dp
        }

        LazyRow {
            items(uiState.credits) { cast ->
                CastItem(
                    cast = cast,
                    cardWidth = cardWidth,
                    avatarSize = cardWidth * 0.8f,
                    onClick = { id ->
                        onAction(DetailsAction.OnCastClick(id))
                    }
                )
            }
        }
    }
}