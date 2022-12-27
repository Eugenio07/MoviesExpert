package com.wao.moviesexpert

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import com.wao.moviesexpert.ui.screens.main.MainScreen
import com.wao.moviesexpert.ui.MyMoviesApp
import com.wao.moviesexpert.ui.Navigation

@ExperimentalFoundationApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Navigation()
        }
    }
}



