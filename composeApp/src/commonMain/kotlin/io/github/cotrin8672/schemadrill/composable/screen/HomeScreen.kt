package io.github.cotrin8672.schemadrill.composable.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.github.cotrin8672.schemadrill.composable.BaseScreen
import io.github.cotrin8672.schemadrill.composable.MenuCard
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import schemadrill.composeapp.generated.resources.Res
import schemadrill.composeapp.generated.resources.word_card

@Composable
@Preview
fun HomeScreen() {
    BaseScreen {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            MenuCard(
                modifier = Modifier.fillMaxWidth(),
                menuTitle = { Text("単語帳") },
                menuIcon = {
                    Icon(
                        painter = painterResource(Res.drawable.word_card),
                        contentDescription = null,
                        modifier = Modifier.size(48.dp)
                    )
                },
                onClick = {}
            )
            Button(
                onClick = { }
            ) {
                Text("短文翻訳")
            }
            Button(
                onClick = { }
            ) {
                Text("AI添削")
            }
        }
    }
}
