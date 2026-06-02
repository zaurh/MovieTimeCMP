package com.zaurh.movietimenew.data.mapper.tv

import com.zaurh.movietimenew.data.models.tv.tv_similar.TvSimilarDTO
import com.zaurh.movietimenew.data.models.tv.tv_similar.TvSimilarItemDTO
import com.zaurh.movietimenew.domain.models.tv.tv_similar.TvSimilar
import com.zaurh.movietimenew.domain.models.tv.tv_similar.TvSimilarItem
import com.zaurh.movietimenew.util.generateImagePath
import com.zaurh.movietimenew.util.orFalse
import com.zaurh.movietimenew.util.orZero

fun TvSimilarDTO.toDomain(): TvSimilar {
    return TvSimilar(
        page = this.page.orZero(),
        results = this.results?.map { it.toDomain() }.orEmpty(),
        totalPages = this.total_pages.orZero(),
        totalResults = this.total_results.orZero()
    )
}

fun TvSimilarItemDTO.toDomain(): TvSimilarItem {
    return TvSimilarItem(
        adult = this.adult.orFalse(),
        backdropPath = generateImagePath(this.backdrop_path),
        genreIds = this.genre_ids.orEmpty(),
        id = this.id.orZero(),
        originCountry = this.origin_country.orEmpty(),
        originalLanguage = this.original_language.orEmpty(),
        originalName = this.original_name.orEmpty(),
        overview = this.overview.orEmpty(),
        popularity = this.popularity.orZero(),
        posterPath = generateImagePath(this.poster_path),
        firstAirDate = this.first_air_date.orEmpty(),
        name = this.name.orEmpty(),
        voteAverage = this.vote_average.orZero(),
        voteCount = this.vote_count.orZero()
    )
}