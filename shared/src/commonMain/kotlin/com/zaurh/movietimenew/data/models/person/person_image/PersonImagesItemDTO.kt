package com.zaurh.movietimenew.data.models.person.person_image
import kotlinx.serialization.Serializable

@Serializable
data class PersonImagesItemDTO(
    val aspect_ratio: Double? = null,
    val height: Int? = null,
    val iso_639_1: String? = null,
    val file_path: String? = null,
    val vote_average: Double? = null,
    val vote_count: Int? = null,
    val width: Int? = null
)