package by.arsy.historyphotos

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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import by.arsy.historyphotos.ui.theme.HistoryPhotosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            // TODO: временная переменная для демонстрации анимации переключения
            var selectedType by rememberSaveable { mutableStateOf(NavType.MAP) }

            HistoryPhotosTheme {
                Scaffold(
                    bottomBar = {
                        BottomNavBar(
                            onClickMap = { selectedType = NavType.MAP },
                            onClickPlaces = { selectedType = NavType.PLACES },
                            onClickHistory = { selectedType = NavType.HISTORY },
                            selectedType = selectedType,
                            modifier =
                                Modifier
                                    .fillMaxWidth()
                                    .background(color = MaterialTheme.colorScheme.surfaceContainer)
                                    .padding(bottom = 12.dp, top = 12.dp) // TODO: взято наугад
                                    .navigationBarsPadding(),
                        )
                    },
                    modifier = Modifier.fillMaxSize(),
                ) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding),
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(
    name: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = "Hello $name!",
        modifier = modifier,
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HistoryPhotosTheme {
        Greeting("Android")
    }
}
