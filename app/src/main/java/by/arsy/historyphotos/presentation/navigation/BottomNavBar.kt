package by.arsy.historyphotos.presentation.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import by.arsy.historyphotos.R
import by.arsy.historyphotos.presentation.theme.HistoryPhotosTheme

@Composable
fun BottomNavBar(
    onClickMap: () -> Unit,
    onClickPlaces: () -> Unit,
    onClickHistory: () -> Unit,
    selectedType: NavType,
    modifier: Modifier = Modifier,
) {
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier,
    ) {
        ButtonBarItem(
            imageResId = R.drawable.ic_nav_map,
            nameResId = R.string.nav_map,
            selected = selectedType == NavType.Map,
            onClick = onClickMap,
        )
        ButtonBarItem(
            imageResId = R.drawable.ic_nav_places,
            nameResId = R.string.nav_places,
            selected = selectedType == NavType.Places,
            onClick = onClickPlaces,
        )
        ButtonBarItem(
            imageResId = R.drawable.ic_nav_history,
            nameResId = R.string.nav_history,
            selected = selectedType == NavType.History,
            onClick = onClickHistory,
        )
    }
}

@Composable
private fun ButtonBarItem(
    @DrawableRes imageResId: Int,
    @StringRes nameResId: Int,
    onClick: () -> Unit,
    selected: Boolean,
    modifier: Modifier = Modifier,
) {
    val name = stringResource(nameResId)
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier =
            modifier.pointerInput(onClick) {
                detectTapGestures(onTap = { onClick() })
            },
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier =
                Modifier
                    .padding(bottom = 4.dp)
                    .size(width = 64.dp, height = 32.dp),
        ) {
            // TODO: возможно в будущем сделать
            //  анимацию "перелета" изображения выделенного элемента навигации
            this@Column.AnimatedVisibility(
                visible = selected,
                enter = fadeIn() + scaleIn(),
                exit = fadeOut() + scaleOut(),
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_nav_selected),
                    contentDescription = name,
                    tint = MaterialTheme.colorScheme.secondaryContainer,
                )
            }
            Icon(
                painter = painterResource(imageResId),
                contentDescription = name,
                tint =
                    if (selected) {
                        MaterialTheme.colorScheme.onSecondaryContainer
                    } else {
                        MaterialTheme.colorScheme.onSurfaceVariant
                    },
            )
        }
        Text(
            text = name,
            style =
                if (selected) {
                    MaterialTheme.typography.labelLarge
                } else {
                    MaterialTheme.typography.labelMedium
                },
            color =
                if (selected) {
                    MaterialTheme.colorScheme.onSurface
                } else {
                    MaterialTheme.colorScheme.onSurfaceVariant
                },
        )
    }
}

@Preview
@Composable
private fun BottomNavBarPreview() {
    HistoryPhotosTheme {
        BottomNavBar(
            onClickMap = {},
            onClickPlaces = {},
            onClickHistory = {},
            selectedType = NavType.Places,
        )
    }
}
