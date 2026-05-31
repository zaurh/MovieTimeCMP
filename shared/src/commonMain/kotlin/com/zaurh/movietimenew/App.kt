package com.zaurh.movietimenew

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.zaurh.movietimenew.presentation.navigation.NavGraph
import com.zaurh.movietimenew.presentation.navigation.Screen
import com.zaurh.movietimenew.ui.theme.MovieTimeTheme

@Composable
@Preview
fun App() {
    MovieTimeTheme {
        val navController = rememberNavController()
        NavGraph(navController = navController, startDestination = Screen.HomeScreen.route)
    }
}

