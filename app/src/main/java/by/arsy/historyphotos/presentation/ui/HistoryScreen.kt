package by.arsy.historyphotos.presentation.ui

import androidx.activity.compose.BackHandler
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import by.arsy.historyphotos.presentation.navigation.NavType

fun NavGraphBuilder.historyScreen(
    backNavigate: () -> Unit,
    modifier: Modifier = Modifier,
) {
    composable<NavType.History> {
        BackHandler { backNavigate() }

        StubScreen(
            name = NavType.History.toString(),
            modifier = modifier,
        )
    }
}
