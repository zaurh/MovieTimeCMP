package com.zaurh.movietimenew.data.mapper.person

import com.zaurh.movietimenew.data.models.person.PersonSocialMediaDTO
import com.zaurh.movietimenew.domain.models.person.person_social_media.PersonSocialMedia
import com.zaurh.movietimenew.util.orZero

fun PersonSocialMediaDTO.toDomain(): PersonSocialMedia {
    return PersonSocialMedia(
        id = this.id.orZero(),
        freebaseMid = this.freebase_mid.orEmpty(),
        freebaseId = this.freebase_id.orEmpty(),
        imdbId = this.imdb_id.orEmpty(),
        tvrageId = this.tvrage_id.orZero(),
        wikidataId = this.wikidata_id.orEmpty(),
        facebookId = this.facebook_id.orEmpty(),
        instagramId = this.instagram_id.orEmpty(),
        tiktokId = this.tiktok_id.orEmpty(),
        twitterId = this.twitter_id.orEmpty(),
        youtubeId = this.youtube_id.orEmpty()
    )
}