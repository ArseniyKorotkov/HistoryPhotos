package by.arsy.historyphotos.feature.places.presentation.viewModel

import by.arsy.historyphotos.feature.places.domain.ImageDomainEntity

data class UiState(
    val imageList: List<ImageDomainEntity> = listOf(),
    val imageDownloadState: ImageDownloadState = ImageDownloadState.Process,
)

sealed interface ImageDownloadState {
    data object Process : ImageDownloadState

    data object Complete : ImageDownloadState
}
