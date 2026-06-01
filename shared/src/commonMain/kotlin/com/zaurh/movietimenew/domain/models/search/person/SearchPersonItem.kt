package com.zaurh.movietimenew.domain.models.search.person

import com.zaurh.movietimenew.util.EMPTY
import com.zaurh.movietimenew.util.ZERO
import com.zaurh.movietimenew.util.ZERO_DOUBLE
import com.zaurh.movietimenew.util.ZERO_LONG

data class SearchPersonItem(
    val id: Long = ZERO_LONG,
    val name: String = EMPTY,
    val originalName: String = EMPTY,
    val gender: Int = ZERO,
    val knownForDepartment: String = EMPTY,
    val popularity: Double = ZERO_DOUBLE,
    val profilePath: String = EMPTY,
    val adult: Boolean = false,
    val knownFor: List<SearchPersonKnownFor> = listOf()
)