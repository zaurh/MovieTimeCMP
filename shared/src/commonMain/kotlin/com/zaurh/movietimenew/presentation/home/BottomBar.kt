package com.zaurh.movietimenew.presentation.home

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource

@Composable
fun BottomBar(
    modifier: Modifier = Modifier,
    tabItems: List<TabItem>,
    pagerState: PagerState,
    onItemClick: (Int) -> Unit,
) {
    BottomAppBar(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp),
        containerColor = Color.Transparent,
        tonalElevation = 0.dp
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(28.dp))
                .background(
                    MaterialTheme.colorScheme.background.copy(alpha = 0.65f)
                )
                .border(
                    1.dp,
                    Color.White.copy(alpha = 0.12f),
                    RoundedCornerShape(28.dp)
                )
                .padding(vertical = 12.dp)
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {

                tabItems.forEach { item ->

                    val selected =
                        item.index == pagerState.currentPage

                    val scale by animateFloatAsState(
                        targetValue = if (selected) 1.1f else 1f,
                        label = "scale"
                    )

                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .size(42.dp)
                            .graphicsLayer {
                                scaleX = scale
                                scaleY = scale
                            }
                            .background(
                                brush = if (selected)
                                    Brush.radialGradient(
                                        colors = listOf(
                                            item.selectedColor.copy(alpha = 0.25f),
                                            Color.Transparent
                                        )
                                    )
                                else
                                    Brush.radialGradient(
                                        colors = listOf(
                                            Color.Transparent,
                                            Color.Transparent
                                        )
                                    ),
                                shape = CircleShape
                            )
                            .clip(CircleShape)
                            .clickable {
                                onItemClick(item.index)
                            }
                    ) {

                        Icon(
                            painter = painterResource(item.icon),
                            contentDescription = null,
                            tint = if (selected)
                                item.selectedColor
                            else
                                item.unselectedColor,
                            modifier = Modifier.size(22.dp) // 👈 nice balanced size
                        )
                    }
                }
            }
        }
    }
}