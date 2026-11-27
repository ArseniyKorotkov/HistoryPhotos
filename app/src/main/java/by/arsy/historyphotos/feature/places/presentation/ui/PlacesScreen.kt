package by.arsy.historyphotos.feature.places.presentation.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import by.arsy.historyphotos.feature.places.presentation.viewModel.ImageDownloadState
import by.arsy.historyphotos.feature.places.presentation.viewModel.PlacesViewModel

@Composable
fun PlacesScreen(
    viewModel: PlacesViewModel,
    modifier: Modifier = Modifier,
) {
    val uiState by viewModel.uiState.collectAsState()

    Box(
        contentAlignment = Alignment.TopStart,
        modifier = modifier,
    ) {
        if (uiState.imageDownloadState == ImageDownloadState.Process) {
            Text("Loading...")
            LaunchedEffect(Unit) {
                viewModel.updateImages()
            }
        } else {
            LazyColumn {
                items(
                    items = uiState.imageList,
                    key = { it.id },
                ) {
                    Text(text = it.title)
                }
            }
        }
    }
}
