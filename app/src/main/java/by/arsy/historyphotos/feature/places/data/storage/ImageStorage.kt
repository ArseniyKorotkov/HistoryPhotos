package by.arsy.historyphotos.feature.places.data.storage

import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.milliseconds

class ImageStorage {
    suspend fun getImageList(): List<ImageDataEntity> {
        delay(3000.milliseconds)
        return listOf(
            ImageDataEntity(
                id = 1,
                url = "1",
            ),
            ImageDataEntity(
                id = 2,
                url = "2",
            ),
            ImageDataEntity(
                id = 3,
                url = "3",
            ),
            ImageDataEntity(
                id = 4,
                url = "4",
            ),
        )
    }
}
