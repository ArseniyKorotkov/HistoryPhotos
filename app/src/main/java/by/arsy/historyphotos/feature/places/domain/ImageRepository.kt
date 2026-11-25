package by.arsy.historyphotos.feature.places.domain

interface ImageRepository {
    suspend fun getImageList(): List<ImageDomainEntity>
}
