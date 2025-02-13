package io.github.cotrin8672.schemadrill.composable

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
actual fun BaseScreen(
    isMainScreen: Boolean,
    content: @Composable (() -> Unit),
) {
    Scaffold {
        Row(
            modifier = Modifier.padding(it).padding(16.dp),
            horizontalArrangement = Arrangement.Start
        ) {
            AppNavigationRail()
            Box(
                modifier = Modifier.fillMaxSize().padding(16.dp)
            ) {
                content()
            }
        }
    }
}

@Composable
fun AppNavigationRail() {
    NavigationRail(
        modifier = Modifier.fillMaxHeight(),
    ) {
        NavigationRailItem(
            selected = true,
            onClick = { },
            icon = { Icon(Icons.Default.Home, contentDescription = null) },
            label = { Text("ホーム") },
            alwaysShowLabel = true
        )
    }
}
