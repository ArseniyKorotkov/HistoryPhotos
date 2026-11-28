package by.arsy.historyphotos.feature.places.data.entity

import by.arsy.historyphotos.feature.places.domain.ImageDomainEntity

data class ImageDataEntity(
    val cid: Long,
    val title: String,
    val file: String,
) {
    fun map(): ImageDomainEntity =
        ImageDomainEntity(
            id = cid,
            title = title,
            file = "https://img.pastvu.com/d/$file",
        )
}
