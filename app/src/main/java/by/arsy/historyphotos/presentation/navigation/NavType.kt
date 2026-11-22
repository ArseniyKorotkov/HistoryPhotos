package by.arsy.historyphotos.presentation.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed interface NavType {
    @Serializable
    data object Map : NavType

    @Serializable
    data object Places : NavType

    @Serializable
    data object History : NavType
}
