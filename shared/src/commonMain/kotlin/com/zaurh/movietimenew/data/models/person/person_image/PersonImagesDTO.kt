package com.zaurh.movietimenew.data.models.person.person_image

import kotlinx.serialization.Serializable

@Serializable
data class PersonImagesDTO(
    val id: Long? = null,
    val profiles: List<PersonImagesItemDTO>? = null
)