package com.zaurh.movietimenew.presentation.details.components

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.zaurh.movietimenew.util.getOutfitFont

@Composable
fun MovieDetailsReviewButton(
    title: String,
    onClick: () -> Unit
) {
    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.background,
        ), onClick = {
            onClick()
        }) {
        Text(
            text = title, color = MaterialTheme.colorScheme.primary, fontFamily = getOutfitFont()
        )
    }
}