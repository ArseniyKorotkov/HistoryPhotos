package by.arsy.historyphotos.presentation.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import by.arsy.historyphotos.presentation.navigation.NavType

@Composable
fun CenterHost(
    navController: NavHostController,
    closeApp: () -> Unit,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = NavType.Map,
    ) {
        mapScreen(
            backNavigate = closeApp,
            modifier = modifier,
        )
        placesScreen(
            backNavigate = { navController.navigate(route = NavType.Map) },
            modifier = modifier,
        )
        historyScreen(
            backNavigate = { navController.navigate(route = NavType.Map) },
            modifier = modifier,
        )
    }
}
