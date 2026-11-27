package by.arsy.historyphotos.feature.places.presentation.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import by.arsy.historyphotos.feature.places.domain.ImageDomainEntity
import by.arsy.historyphotos.feature.places.presentation.viewModel.ImageDownloadState
import by.arsy.historyphotos.feature.places.presentation.viewModel.PlacesViewModel
import coil3.compose.AsyncImage
import java.nio.file.WatchEvent

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
                ) { imageEntity ->
                    ImageRow(
                        imageEntity = imageEntity,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}

@Composable
fun ImageRow(
    imageEntity: ImageDomainEntity,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
    ) {
        AsyncImage(
            model = imageEntity.file,
            contentDescription = null,
            modifier = Modifier.size(50.dp)
        )
        Text(
            text = imageEntity.title
        )

    }
}
