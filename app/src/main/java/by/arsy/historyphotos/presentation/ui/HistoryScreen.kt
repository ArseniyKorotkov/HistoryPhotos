package by.arsy.historyphotos.presentation.ui

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import by.arsy.historyphotos.presentation.navigation.NavType

fun NavGraphBuilder.historyScreen(modifier: Modifier = Modifier) {
    composable<NavType.History> {
        StubScreen(
            name = NavType.History.toString(),
            modifier = modifier,
        )
    }
}
