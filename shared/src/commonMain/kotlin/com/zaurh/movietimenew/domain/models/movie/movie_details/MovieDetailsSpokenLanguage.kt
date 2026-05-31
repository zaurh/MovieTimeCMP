package com.zaurh.movietimenew.domain.models.movie.movie_details

import com.zaurh.movietimenew.util.EMPTY

data class MovieDetailsSpokenLanguage(
    val englishName: String = EMPTY,
    val languageCode: String = EMPTY,
    val name: String = EMPTY
)