package com.zaurh.movietimenew.data.mapper.person

import com.zaurh.movietimenew.data.models.person.PersonMoviesCastItemDTO
import com.zaurh.movietimenew.data.models.person.PersonMoviesDTO
import com.zaurh.movietimenew.domain.models.person.person_movies.PersonMovies
import com.zaurh.movietimenew.domain.models.person.person_movies.PersonMoviesCastItem
import com.zaurh.movietimenew.util.generateImagePath
import com.zaurh.movietimenew.util.orFalse
import com.zaurh.movietimenew.util.orZero

fun PersonMoviesDTO.toDomain(): PersonMovies {
    return PersonMovies(
        cast = this.cast?.map { it.toDomain() }.orEmpty(),
        id = this.id.orZero()
    )
}

fun PersonMoviesCastItemDTO.toDomain(): PersonMoviesCastItem {
    return PersonMoviesCastItem(
        adult = this.adult.orFalse(),
        backdropPath = this.backdrop_path.orEmpty(),
        genreIds = this.genre_ids.orEmpty(),
        id = this.id.orZero(),
        originalLanguage = this.original_language.orEmpty(),
        originalTitle = this.original_title.orEmpty(),
        overview = this.overview.orEmpty(),
        popularity = this.popularity.orZero(),
        posterPath = generateImagePath(this.poster_path),
        releaseDate = this.release_date.orEmpty(),
        title = this.title.orEmpty(),
        video = this.video.orFalse(),
        voteAverage = this.vote_average.orZero(),
        voteCount = this.vote_count.orZero(),
        character = this.character.orEmpty(),
        creditId = this.credit_id.orEmpty(),
        order = this.order.orZero()
    )
}