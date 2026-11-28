package by.arsy.historyphotos.feature.places.presentation.navigation

import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import by.arsy.historyphotos.feature.places.data.ImageRepositoryImpl
import by.arsy.historyphotos.feature.places.data.storage.ImageStorage
import by.arsy.historyphotos.feature.places.domain.GetImagesUseCase
import by.arsy.historyphotos.feature.places.presentation.ui.PlacesScreen
import by.arsy.historyphotos.feature.places.presentation.viewModel.PlacesViewModel
import by.arsy.historyphotos.presentation.navigation.NavType

fun NavGraphBuilder.placesScreen(modifier: Modifier = Modifier) {
    composable<NavType.Places> {
        PlacesScreen(
            viewModel =
                viewModel(
                    factory =
                        viewModelFactory {
                            initializer {
                                val storage = ImageStorage()
                                val repository = ImageRepositoryImpl(storage)
                                val useCase = GetImagesUseCase(repository)
                                PlacesViewModel(useCase)
                            }
                        },
                ),
            modifier = modifier,
        )
    }
}
