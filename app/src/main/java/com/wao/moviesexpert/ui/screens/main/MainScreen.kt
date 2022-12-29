package com.wao.moviesexpert.ui.screens.main

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.wao.moviesexpert.model.MediaItem
import com.wao.moviesexpert.ui.MyMoviesApp

@ExperimentalFoundationApi
@Composable
fun MainScreen(onMediaClick: (MediaItem) -> Unit) {
    MyMoviesApp {
        Scaffold(topBar = { MainAppBar() })
        { padding ->
            MediaList(onMediaClick = onMediaClick, modifier = Modifier.padding(padding))
        }
    }
}