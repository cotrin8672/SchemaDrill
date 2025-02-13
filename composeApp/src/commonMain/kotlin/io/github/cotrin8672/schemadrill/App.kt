package io.github.cotrin8672.schemadrill

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.materialkolor.rememberDynamicColorScheme
import io.github.cotrin8672.schemadrill.composable.HomeRoute
import io.github.cotrin8672.schemadrill.composable.screen.HomeScreen
import io.github.cotrin8672.schemadrill.composable.theme.SeedColor
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App(
    darkTheme: Boolean = isSystemInDarkTheme(),
) {
    val colorScheme = rememberDynamicColorScheme(SeedColor, darkTheme, false)
    MaterialTheme(
        colorScheme = colorScheme
    ) {
        HomeScreen()
    }
}

@Composable
fun AppNavHost(
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navController,
        startDestination = HomeRoute
    ) {
        composable<HomeRoute> {
            HomeScreen()
        }
    }
}
