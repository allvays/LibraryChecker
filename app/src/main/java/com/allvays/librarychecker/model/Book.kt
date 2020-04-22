package com.allvays.librarychecker.model

import android.graphics.Bitmap

data class Book(
    val title: String,
    val author: String,
    val synopsis : String,
    val cover : Int,
    val art: Int
)