package com.wao.moviesexpert.ui.screens.detail

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.wao.moviesexpert.model.getMedia
import com.wao.moviesexpert.ui.screens.shared.ArrowBackIcon
import com.wao.moviesexpert.ui.screens.shared.Thumb

@Composable
fun DetailScreen(mediaId: Int, onUpClick: () -> Unit) {
    val mediaItem = remember { getMedia().first { it.id == mediaId } }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = mediaItem.title) },
                navigationIcon = { ArrowBackIcon(onUpClick) }
            )
        }
    ) { padding ->
        Thumb(mediaItem = mediaItem, Modifier.padding(padding))
    }
}