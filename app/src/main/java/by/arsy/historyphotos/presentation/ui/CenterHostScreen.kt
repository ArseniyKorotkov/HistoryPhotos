package by.arsy.historyphotos.presentation.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import by.arsy.historyphotos.feature.places.presentation.navigation.placesScreen
import by.arsy.historyphotos.presentation.navigation.NavType

@Composable
fun CenterHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = NavType.Map,
    ) {
        mapScreen(
            modifier = modifier,
        )
        placesScreen(
            modifier = modifier,
        )
        historyScreen(
            modifier = modifier,
        )
    }
}
