package io.github.cotrin8672.schemadrill.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.materialkolor.rememberDynamicColorScheme
import io.github.cotrin8672.schemadrill.composable.theme.SeedColor
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import schemadrill.composeapp.generated.resources.Res
import schemadrill.composeapp.generated.resources.right_arrow
import schemadrill.composeapp.generated.resources.word_card

@Composable
fun MenuCard(
    modifier: Modifier = Modifier,
    menuTitle: @Composable () -> Unit,
    menuIcon: @Composable () -> Unit,
    onClick: () -> Unit,
) {
    Card(
        modifier = modifier.clickable {

        }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier.padding(16.dp)
            ) {
                Box(
                    modifier = Modifier.padding(start = 8.dp, end = 16.dp)
                ) {
                    menuIcon()
                }
                menuTitle()
            }
            Icon(
                painter = painterResource(Res.drawable.right_arrow),
                contentDescription = null,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Composable
@Preview
fun MenuCardPreview() {
    val colorScheme = rememberDynamicColorScheme(
        SeedColor,
        false,
        false
    )

    MaterialTheme(
        colorScheme = colorScheme
    ) {
        MenuCard(
            modifier = Modifier.fillMaxWidth(),
            menuTitle = {
                Text(
                    text = "単語帳",
                    style = MaterialTheme.typography.headlineSmall
                )
            },
            menuIcon = {
                Icon(
                    painter = painterResource(Res.drawable.word_card),
                    contentDescription = null,
                    modifier = Modifier.size(36.dp)
                )
            },
            onClick = {}
        )
    }
}
