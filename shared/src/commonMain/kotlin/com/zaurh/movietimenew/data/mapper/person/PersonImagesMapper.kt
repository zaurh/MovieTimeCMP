package com.zaurh.movietimenew.data.mapper.person

import com.zaurh.movietimenew.data.models.person.person_image.PersonImagesDTO
import com.zaurh.movietimenew.data.models.person.person_image.PersonImagesItemDTO
import com.zaurh.movietimenew.domain.models.person.person_image.PersonImages
import com.zaurh.movietimenew.domain.models.person.person_image.PersonImagesItem
import com.zaurh.movietimenew.util.generateImagePath
import com.zaurh.movietimenew.util.orZero

fun PersonImagesDTO.toDomain(): PersonImages {
    return PersonImages(
        id = this.id.orZero(),
        profiles = this.profiles?.map { it.toDomain() }.orEmpty()
    )
}

fun PersonImagesItemDTO.toDomain(): PersonImagesItem {
    return PersonImagesItem(
        aspectRatio = this.aspect_ratio.orZero(),
        height = this.height.orZero(),
        languageCode = this.iso_639_1.orEmpty(),
        filePath = generateImagePath(this.file_path),
        voteAverage = this.vote_average.orZero(),
        voteCount = this.vote_count.orZero(),
        width = this.width.orZero()
    )
}