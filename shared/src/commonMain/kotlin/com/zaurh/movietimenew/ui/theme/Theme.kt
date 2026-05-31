package com.zaurh.movietimenew.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    surface = ThemeColors.Night.surface,
    background = ThemeColors.Night.background,
    primary = ThemeColors.Night.text,
)

private val LightColorScheme = lightColorScheme(
    surface = ThemeColors.Day.surface,
    background = ThemeColors.Day.background,
    primary = ThemeColors.Day.text
)

@Composable
fun MovieTimeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme,
        typography = Typography,
        content = content
    )
}