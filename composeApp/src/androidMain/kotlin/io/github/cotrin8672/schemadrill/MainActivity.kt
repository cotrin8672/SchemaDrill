package io.github.cotrin8672.schemadrill

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.materialkolor.rememberDynamicColorScheme
import io.github.cotrin8672.schemadrill.composable.screen.HomeScreen
import io.github.cotrin8672.schemadrill.composable.theme.SeedColor

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            App()
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    MaterialTheme(
        colorScheme = rememberDynamicColorScheme(
            SeedColor, true ,true
        )
    ) {
        HomeScreen()
    }
}
