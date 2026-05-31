package com.zaurh.movietimenew.presentation.main.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zaurh.movietimenew.presentation.main.MainEvent
import com.zaurh.movietimenew.presentation.main.MainViewModel
import com.zaurh.movietimenew.presentation.model.MovieUIModel
import com.zaurh.movietimenew.presentation.shared.MovieItem

@Composable
fun MainMovieComponent(
    title: String,
    movieList: List<MovieUIModel>,
    viewModel: MainViewModel
) {
    Text(
        text = title,
        modifier = Modifier.padding(12.dp),
        color = MaterialTheme.colorScheme.primary,
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold
    )
    LazyRow {
        items(movieList) {
            MovieItem(it) { movieId ->
                viewModel.onEvent(MainEvent.OnMovieClicked(movieId))
            }
        }
    }
}