package com.zaurh.movietimenew.presentation.shared

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import movietimenew.shared.generated.resources.Res
import movietimenew.shared.generated.resources.ic_arrow_left
import movietimenew.shared.generated.resources.ic_arrow_right
import org.jetbrains.compose.resources.painterResource

@Composable
fun PageSwitcher(
    currentPage: Int,
    totalPage: Int,
    onPreviousClick: () -> Unit,
    onNextClick: () -> Unit
) {
    Row(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(enabled = currentPage > 1, onClick = {
            onPreviousClick()
        }) {
            Icon(
                modifier = Modifier.size(24.dp),
                painter = painterResource(Res.drawable.ic_arrow_left),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary
            )
        }
        Text(
            text = "$currentPage of $totalPage",
            color = MaterialTheme.colorScheme.primary
        )
        IconButton(
            enabled = currentPage < totalPage,
            onClick = {
                onNextClick()
            }) {
            Icon(
                modifier = Modifier.size(24.dp),
                painter = painterResource(Res.drawable.ic_arrow_right),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary
            )
        }
    }

}