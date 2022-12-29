package com.wao.moviesexpert.ui.screens.main

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.wao.moviesexpert.R
import com.wao.moviesexpert.model.MediaItem
import com.wao.moviesexpert.model.getMedia
import com.wao.moviesexpert.ui.screens.shared.Thumb

@ExperimentalFoundationApi
@Composable
fun MediaList(onMediaClick: (MediaItem) -> Unit, modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(dimensionResource(R.dimen.cell_min_width)),
        contentPadding = PaddingValues(dimensionResource(R.dimen.padding_xsmall)),
        modifier = Modifier
    ) {
        items(getMedia()) {
            MediaListItem(
                mediaItem = it,
                onClick = {onMediaClick(it)},
                modifier = Modifier.padding(dimensionResource(R.dimen.padding_xsmall))
            )
        }
    }
}


@Preview
@Composable
fun MediaListItemPreview() {
    val mediaItem = MediaItem(1, "Item 1", "", MediaItem.Type.VIDEO)
 //   MediaListItem(mediaItem = mediaItem, navController = navController)
}


@Composable
fun MediaListItem(
    mediaItem: MediaItem,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .clickable(onClick = onClick)
    ) {
        Thumb(
            mediaItem = mediaItem)
        Title(mediaItem)
    }
}

@Composable
private fun Title(mediaItem: MediaItem) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.secondary)
            .padding(dimensionResource(R.dimen.padding_medium))
    ) {
        Text(
            text = mediaItem.title,
            style = MaterialTheme.typography.h6
        )
    }
}
