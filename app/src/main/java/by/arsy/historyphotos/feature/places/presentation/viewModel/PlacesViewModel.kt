package by.arsy.historyphotos.feature.places.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.arsy.historyphotos.feature.places.domain.GetImagesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PlacesViewModel(
    private val getImagesUseCase: GetImagesUseCase,
) : ViewModel() {
    private val _uiState = MutableStateFlow(UiState())

    val uiState = _uiState.asStateFlow()

    fun updateImages() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                _uiState.value =
                    _uiState.value.copy(
                        imageList = getImagesUseCase.execute(),
                        imageDownloadState = ImageDownloadState.Complete,
                    )
            }
        }
    }
}
