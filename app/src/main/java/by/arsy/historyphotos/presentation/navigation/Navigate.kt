package by.arsy.historyphotos.presentation.navigation

import androidx.navigation.NavController

fun NavController.bottomNavigate(route: NavType) {
    this.navigate(route = route) {
        popUpTo(route = NavType.Map) {
            saveState = true
        }

        launchSingleTop = true

        restoreState = true
    }
}
