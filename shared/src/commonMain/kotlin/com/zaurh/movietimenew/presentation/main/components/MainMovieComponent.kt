package com.zaurh.movietimenew.presentation.main.components

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
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
    BoxWithConstraints {

        val posterWidth = when {
            maxWidth < 600.dp -> 100.dp
            maxWidth < 900.dp -> 140.dp
            else -> 180.dp
        }

        Column {
            Text(
                text = title,
                modifier = Modifier.padding(12.dp),
                color = MaterialTheme.colorScheme.primary,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )

            LazyRow {
                items(movieList) {
                    MovieItem(
                        movieData = it,
                        posterWidth = posterWidth
                    ) { movieId ->
                        viewModel.onEvent(MainEvent.OnMovieClicked(movieId))
                    }
                }
            }
        }
    }
}