package com.wao.moviesexpert.ui

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import com.wao.moviesexpert.ui.theme.MoviesExpertTheme

@Composable
fun MyMoviesApp(content: @Composable () -> Unit) {
    MoviesExpertTheme {
        Surface(color = MaterialTheme.colors.background) {
            content()
        }
    }
}