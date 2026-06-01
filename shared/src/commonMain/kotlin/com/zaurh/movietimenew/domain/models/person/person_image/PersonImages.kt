package com.zaurh.movietimenew.domain.models.person.person_image

import com.zaurh.movietimenew.util.ZERO_LONG

data class PersonImages(
    val id: Long = ZERO_LONG,
    val profiles: List<PersonImagesItem> = listOf()
)