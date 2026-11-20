package by.arsy.historyphotos

import android.os.Bundle
import androidx.activity.ComponentActivity
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
                                navController.navigate(route = NavType.MAP.name)
                            },
                            onClickPlaces = {
                                navController.navigate(route = NavType.PLACES.name)
                            },
                            onClickHistory = {
                                navController.navigate(route = NavType.HISTORY.name)
                            },
                            selectedType =
                                NavType.valueOf(
                                    currentRoute.value?.destination?.route ?: NavType.MAP.name,
                                ),
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
        modifier: Modifier = Modifier,
    ) {
        NavHost(
            navController = navController,
            startDestination = NavType.MAP.name,
        ) {
            composable(
                route = NavType.MAP.name,
            ) {
                StubScreen(
                    name = NavType.MAP.name,
                    modifier = modifier,
                )
            }
            composable(
                route = NavType.PLACES.name,
            ) {
                StubScreen(
                    name = NavType.PLACES.name,
                    modifier = modifier,
                )
            }
            composable(
                route = NavType.HISTORY.name,
            ) {
                StubScreen(
                    name = NavType.HISTORY.name,
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
