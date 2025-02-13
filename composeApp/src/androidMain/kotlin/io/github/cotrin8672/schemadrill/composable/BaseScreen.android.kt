package io.github.cotrin8672.schemadrill.composable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController

@Composable
actual fun BaseScreen(
    isMainScreen: Boolean,
    content: @Composable (() -> Unit),
) {
    if (isMainScreen) {
        Scaffold(
            bottomBar = { AppBottomNavigation() }
        ) {
            Box(modifier = Modifier.padding(it)) {
                content()
            }
        }
    } else {
        Scaffold {
            Box(modifier = Modifier.padding(it)) {
                content()
            }
        }
    }
}

@Composable
fun AppBottomNavigation() {
    NavigationBar {
        val navController = rememberNavController()

        NavigationBarItem(
            selected = true,
            onClick = {},
            icon = { Icon(Icons.Default.Home, contentDescription = null) },
            label = { Text("ホーム") }
        )
    }
}
