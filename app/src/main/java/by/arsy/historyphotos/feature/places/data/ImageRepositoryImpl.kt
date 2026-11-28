package by.arsy.historyphotos.feature.places.data

import by.arsy.historyphotos.feature.places.data.storage.ImageStorage
import by.arsy.historyphotos.feature.places.domain.ImageDomainEntity
import by.arsy.historyphotos.feature.places.domain.ImageRepository

class ImageRepositoryImpl(
    private val imageStorage: ImageStorage,
) : ImageRepository {
    override suspend fun getImageList(): List<ImageDomainEntity> = imageStorage.getImageList().map { it.map() }
}
