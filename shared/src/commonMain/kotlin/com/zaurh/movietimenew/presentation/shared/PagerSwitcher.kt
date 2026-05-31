package com.zaurh.movietimenew.presentation.shared

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

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
//            Icon(
//                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
//                contentDescription = null,
//                tint = MaterialTheme.colorScheme.primary
//            )
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
//            Icon(
//                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
//                contentDescription = null,
//                tint = MaterialTheme.colorScheme.primary
//            )
        }
    }

}