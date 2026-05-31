package com.zaurh.movietimenew.domain.repository

import com.zaurh.movietimenew.domain.models.genres.Genres
import com.zaurh.movietimenew.util.Result

interface GenreRepository {
    suspend fun getGenres(): Result<Genres>
}