package com.zaurh.movietimenew.data.mapper.genre

import com.zaurh.movietimenew.data.models.genres.GenresDTO
import com.zaurh.movietimenew.data.models.genres.GenresItemDTO
import com.zaurh.movietimenew.domain.models.genres.Genres
import com.zaurh.movietimenew.domain.models.genres.GenresItem
import com.zaurh.movietimenew.util.orZero

fun GenresDTO.toDomain(): Genres {
    return Genres(
        genres = this.genres?.map { it.toDomain() }.orEmpty()
    )
}

fun GenresItemDTO.toDomain(): GenresItem {
    return GenresItem(
        id = this.id.orZero(),
        name = this.name.orEmpty()
    )
}