package com.zaurh.movietimenew.data.models.person

import kotlinx.serialization.Serializable

@Serializable
data class PersonSocialMediaDTO(
    val id: Long? = null,
    val freebase_mid: String? = null,
    val freebase_id: String? = null,
    val imdb_id: String? = null,
    val tvrage_id: Long? = null,
    val wikidata_id: String? = null,
    val facebook_id: String? = null,
    val instagram_id: String? = null,
    val tiktok_id: String? = null,
    val twitter_id: String? = null,
    val youtube_id: String? = null
)