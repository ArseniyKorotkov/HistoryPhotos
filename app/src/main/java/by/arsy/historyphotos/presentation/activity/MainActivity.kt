package by.arsy.historyphotos.presentation.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import by.arsy.historyphotos.presentation.navigation.BottomNavBar
import by.arsy.historyphotos.presentation.navigation.NavType
import by.arsy.historyphotos.presentation.theme.HistoryPhotosTheme
import by.arsy.historyphotos.presentation.ui.CenterHost

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            val currentRoute = navController.currentBackStackEntryAsState()

            HistoryPhotosTheme {
                Scaffold(
                    bottomBar = {
                        BottomNavBar(
                            onClickMap = {
                                navController.navigate(route = NavType.Map)
                            },
                            onClickPlaces = {
                                navController.navigate(route = NavType.Places)
                            },
                            onClickHistory = {
                                navController.navigate(route = NavType.History)
                            },
                            selectedType =
                                currentRoute.value?.destination?.let {
                                    when {
                                        it.hasRoute<NavType.Places>() -> NavType.Places
                                        it.hasRoute<NavType.History>() -> NavType.History
                                        else -> NavType.Map
                                    }
                                } ?: NavType.Map,
                            modifier =
                                Modifier
                                    .fillMaxWidth()
                                    .background(color = MaterialTheme.colorScheme.surfaceContainer)
                                    .padding(bottom = 16.dp, top = 12.dp)
                                    .navigationBarsPadding(),
                        )
                    },
                    modifier = Modifier.fillMaxSize(),
                ) { innerPadding ->
                    CenterHost(
                        navController = navController,
                        closeApp = { this.finishAffinity() },
                        modifier =
                            Modifier
                                .padding(paddingValues = innerPadding)
                                .fillMaxSize(),
                    )
                }
            }
        }
    }
}
