package com.zaurh.movietimenew

import androidx.compose.ui.window.ComposeUIViewController
import com.zaurh.movietimenew.di.initKoin

fun MainViewController() = ComposeUIViewController {
    initKoin()
    App()
}