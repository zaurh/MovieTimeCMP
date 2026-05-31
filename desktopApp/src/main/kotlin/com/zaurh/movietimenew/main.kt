package com.zaurh.movietimenew

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.zaurh.movietimenew.di.initKoin

fun main() = application {
    initKoin()

    Window(
        onCloseRequest = ::exitApplication,
        title = "MovieTimeNew",
    ) {
        App()
    }
}