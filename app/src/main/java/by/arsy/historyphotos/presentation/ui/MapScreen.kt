package by.arsy.historyphotos.presentation.ui

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import by.arsy.historyphotos.presentation.navigation.NavType

fun NavGraphBuilder.mapScreen(modifier: Modifier = Modifier) {
    composable<NavType.Map> {
        StubScreen(
            name = NavType.Map.toString(),
            modifier = modifier,
        )
    }
}
