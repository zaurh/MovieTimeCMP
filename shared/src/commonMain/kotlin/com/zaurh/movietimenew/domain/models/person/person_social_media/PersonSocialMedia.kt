package com.zaurh.movietimenew.domain.models.person.person_social_media

import com.zaurh.movietimenew.util.EMPTY
import com.zaurh.movietimenew.util.ZERO_LONG

data class PersonSocialMedia(
    val id: Long = ZERO_LONG,
    val freebaseMid: String = EMPTY,
    val freebaseId: String = EMPTY,
    val imdbId: String = EMPTY,
    val tvrageId: Long = ZERO_LONG,
    val wikidataId: String = EMPTY,
    val facebookId: String = EMPTY,
    val instagramId: String = EMPTY,
    val tiktokId: String = EMPTY,
    val twitterId: String = EMPTY,
    val youtubeId: String = EMPTY
)