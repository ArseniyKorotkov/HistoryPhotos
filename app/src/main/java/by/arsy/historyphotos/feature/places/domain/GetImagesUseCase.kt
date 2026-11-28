package by.arsy.historyphotos.feature.places.domain

class GetImagesUseCase(
    private val imageRepository: ImageRepository,
) {
    suspend fun execute(): List<ImageDomainEntity> = imageRepository.getImageList()
}
