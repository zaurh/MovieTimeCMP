package com.zaurh.movietimenew.presentation.main.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zaurh.movietimenew.domain.models.genres.GenresItem
import com.zaurh.movietimenew.util.getOutfitFont

@Composable
fun GenresItem(
    genre: GenresItem,
    onGenreClick: (String, Long) -> Unit
) {
    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.background
        ), modifier = Modifier.padding(start = 8.dp), onClick = {
            onGenreClick(genre.name, genre.id)
        }) {
        Text(
            text = genre.name.replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() },
            color = MaterialTheme.colorScheme.primary,
            fontFamily = getOutfitFont()
        )
    }
}