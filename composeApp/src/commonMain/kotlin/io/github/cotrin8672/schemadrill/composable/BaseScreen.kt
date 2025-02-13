package io.github.cotrin8672.schemadrill.composable

import androidx.compose.runtime.Composable

@Composable
expect fun BaseScreen(
    isMainScreen: Boolean = true,
    content: @Composable () -> Unit,
)
