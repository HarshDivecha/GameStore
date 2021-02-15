package com.example.practice6.store

import com.squareup.moshi.Json

data class GameTile(
    val title:String,
    @Json(name = "img") val imgUrl: String
)
