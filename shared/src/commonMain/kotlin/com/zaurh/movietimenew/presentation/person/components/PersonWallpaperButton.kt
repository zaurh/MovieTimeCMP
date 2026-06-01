package com.zaurh.movietimenew.presentation.person.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.zaurh.movietimenew.util.getOutfitFont

@Composable
fun PersonWallpaperButton(
    onClicked: () -> Unit
) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        onClick = {
            onClicked()
        },
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.background
        )
    ) {
        Text(
            text = "Wallpapers",
            fontFamily = getOutfitFont(),
            color = MaterialTheme.colorScheme.primary
        )
    }
}