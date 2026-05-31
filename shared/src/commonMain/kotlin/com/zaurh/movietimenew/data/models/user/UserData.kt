package com.zaurh.movietimenew.data.models.user
import com.zaurh.movietimenew.util.EMPTY

data class UserData(
    val id: String = EMPTY,
    val username: String = EMPTY,
    val email: String = EMPTY,
    val password: String = EMPTY,
    val favoriteMovies: List<FavoriteData> = listOf(),
)