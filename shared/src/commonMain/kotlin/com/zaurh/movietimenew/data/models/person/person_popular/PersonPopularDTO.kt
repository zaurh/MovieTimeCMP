package com.zaurh.movietimenew.data.models.person.person_popular
import kotlinx.serialization.Serializable

@Serializable
data class PersonPopularDTO(
    val page: Int? = null,
    val results: List<PersonPopularItemDTO>? = null,
    val total_pages: Int? = null,
    val total_results: Int? = null
)