package io.github.cotrin8672.schemadrill

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "SchemaDrill",
    ) {
        App()
    }
}
