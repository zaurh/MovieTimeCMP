package com.zaurh.movieappintern2.data.mapper.movie

import com.zaurh.movietimenew.data.models.movie.movie_recommendations.MovieRecommendationsDTO
import com.zaurh.movietimenew.data.models.movie.movie_recommendations.MovieRecommendationsItemDTO
import com.zaurh.movietimenew.domain.models.movie.movie_recommendations.MovieRecommendations
import com.zaurh.movietimenew.domain.models.movie.movie_recommendations.MovieRecommendationsItem
import com.zaurh.movietimenew.util.generateImagePath
import com.zaurh.movietimenew.util.orFalse
import com.zaurh.movietimenew.util.orZero

fun MovieRecommendationsDTO.toDomain(): MovieRecommendations {
    return MovieRecommendations(
        page = page.orZero(),
        results = results?.map { it.toDomain() }.orEmpty(),
        totalPages = total_pages.orZero(),
        totalResults = total_results.orZero()
    )
}

fun MovieRecommendationsItemDTO.toDomain(): MovieRecommendationsItem {
    return MovieRecommendationsItem(
        adult = adult.orFalse(),
        backdropPath = generateImagePath(this.backdrop_path),
        id = id.orZero(),
        title = title.orEmpty(),
        originalTitle = original_title.orEmpty(),
        overview = overview.orEmpty(),
        posterPath = generateImagePath(this.poster_path),
        mediaType = media_type.orEmpty(),
        originalLanguage = original_language.orEmpty(),
        genreIds = genre_ids.orEmpty(),
        popularity = popularity.orZero(),
        releaseDate = release_date.orEmpty(),
        softcore = softcore.orFalse(),
        video = video.orFalse(),
        voteAverage = vote_average.orZero(),
        voteCount = vote_count.orZero()
    )
}