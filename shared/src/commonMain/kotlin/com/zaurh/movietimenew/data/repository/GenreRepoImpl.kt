package com.zaurh.movietimenew.data.repository

import com.zaurh.movietimenew.data.mapper.genre.toDomain
import com.zaurh.movietimenew.data.service.GenreApi
import com.zaurh.movietimenew.domain.models.genres.Genres
import com.zaurh.movietimenew.domain.repository.GenreRepository
import com.zaurh.movietimenew.util.Result

class GenreRepoImpl(
    private val api: GenreApi
) : GenreRepository {

    override suspend fun getGenres(): Result<Genres> {
        return try {
            val genresDTO = api.getGenres("en")
            Result.Success(genresDTO.toDomain())
        } catch (e: Exception) {
            Result.Error(message = e.message.toString())
        }
    }
}