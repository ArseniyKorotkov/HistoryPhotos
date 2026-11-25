package by.arsy.historyphotos.feature.places.data.storage

import by.arsy.historyphotos.feature.places.domain.ImageDomainEntity

data class ImageDataEntity(
    val id: Long,
    val url: String,
) {
    fun map(): ImageDomainEntity =
        ImageDomainEntity(
            id = id,
            url = url,
        )
}
