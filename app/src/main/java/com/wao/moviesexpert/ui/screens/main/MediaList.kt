package com.wao.moviesexpert.ui.screens.main

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayCircleOutline
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.wao.moviesexpert.R
import com.wao.moviesexpert.ui.model.MediaItem
import com.wao.moviesexpert.ui.model.getMedia

@ExperimentalFoundationApi
@Preview
@Composable
fun MediaList(modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        cells = GridCells.Adaptive(dimensionResource(R.dimen.cell_min_width)),
        contentPadding = PaddingValues(dimensionResource(R.dimen.padding_xsmall)),
        modifier = Modifier
    ) {
        items(getMedia()) {
            MediaListItem(
                mediaItem = it,
                modifier = Modifier.padding(dimensionResource(R.dimen.padding_xsmall))
            )
        }
    }
}


@Preview
@Composable
fun MediaListItemPreview() {
    val mediaItem = MediaItem(1, "Item 1", "", MediaItem.Type.VIDEO)
    MediaListItem(mediaItem = mediaItem)
}


@Composable
fun MediaListItem(mediaItem: MediaItem, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
    ) {
        Box(
            modifier = Modifier
                .height(dimensionResource(R.dimen.cell_thumb_height))
                .fillMaxWidth()
        ) {
            AsyncImage(
                model = mediaItem.thumb,
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            if (mediaItem.type == MediaItem.Type.VIDEO) {
                Icon(
                    Icons.Default.PlayCircleOutline,
                    contentDescription = null,
                    modifier = Modifier
                        .size(dimensionResource(R.dimen.cell_play_icon_size))
                        .align(Alignment.Center),
                    tint = Color.White
                )
            }
        }
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
}
