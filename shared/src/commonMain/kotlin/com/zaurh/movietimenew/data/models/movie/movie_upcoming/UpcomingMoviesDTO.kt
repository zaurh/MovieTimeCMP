package com.zaurh.movietimenew.data.models.movie.movie_upcoming

import kotlinx.serialization.Serializable

@Serializable
data class UpcomingMoviesDTO(
    val dates: UpcomingMoviesDatesDTO,
    val page: Int,
    val results: List<UpcomingMoviesItemDTO>,
    val total_pages: Int,
    val total_results: Int
)