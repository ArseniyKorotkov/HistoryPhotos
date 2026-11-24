package by.arsy.historyphotos.presentation.ui

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import by.arsy.historyphotos.presentation.navigation.NavType

fun NavGraphBuilder.placesScreen(modifier: Modifier = Modifier) {
    composable<NavType.Places> {
        StubScreen(
            name = NavType.Places.toString(),
            modifier = modifier,
        )
    }
}
