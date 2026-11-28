package by.arsy.historyphotos.feature.places.data.storage

import by.arsy.historyphotos.feature.places.data.entity.ImageDataEntity
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.milliseconds

class ImageStorage {
    suspend fun getImageList(): List<ImageDataEntity> {
        delay(3000.milliseconds)
        return listOf(
            ImageDataEntity(
                cid = 801671,
                title = "Перекрёсток улиц Советской и Ленинской",
                file = "/f/0/o/f0o4h75hj65k7jexwq.jpg",
            ),
            ImageDataEntity(
                cid = 530072,
                title = "Беларуская кантора Дзяржаўнага банка СССР",
                file = "3/s/q/3sq6yxxuzafzcpy2dr.jpg",
            ),
            ImageDataEntity(
                cid = 2427813,
                title = "На санях па вуліцы Захараўскай",
                file = "l/n/0/ln024018hymlbhjrr9.jpg",
            ),
            ImageDataEntity(
                cid = 2616361,
                title = "Руіны Ленінскай вуліцы",
                file = "4/9/5/4955kqd6z01414ar16.jpg",
            ),
        )
    }
}
