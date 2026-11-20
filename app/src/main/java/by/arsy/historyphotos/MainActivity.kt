package by.arsy.historyphotos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import by.arsy.historyphotos.ui.theme.HistoryPhotosTheme

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
                        onBackHandler = {
                            if (currentRoute.value?.destination?.hasRoute<NavType.Map>() == true) {
                                this.finishAffinity()
                            } else {
                                navController.navigate(route = NavType.Map)
                            }
                        },
                        modifier =
                            Modifier
                                .padding(paddingValues = innerPadding)
                                .fillMaxSize(),
                    )
                }
            }
        }
    }

    @Composable
    private fun CenterHost(
        navController: NavHostController,
        onBackHandler: () -> Unit,
        modifier: Modifier = Modifier,
    ) {
        NavHost(
            navController = navController,
            startDestination = NavType.Map,
        ) {
            composable<NavType.Map> {
                BackHandler { onBackHandler() }

                StubScreen(
                    name = NavType.Map.toString(),
                    modifier = modifier,
                )
            }
            composable<NavType.Places> {
                BackHandler { onBackHandler() }

                StubScreen(
                    name = NavType.Places.toString(),
                    modifier = modifier,
                )
            }
            composable<NavType.History> {
                BackHandler { onBackHandler() }

                StubScreen(
                    name = NavType.History.toString(),
                    modifier = modifier,
                )
            }
        }
    }
}

@Composable
fun StubScreen(
    name: String,
    modifier: Modifier = Modifier,
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier,
    ) {
        Text(text = "Screen $name")
    }
}

@Preview(showBackground = true)
@Composable
fun StubScreenPreview() {
    HistoryPhotosTheme {
        StubScreen("Android")
    }
}
