package com.example.practice6.store

import com.squareup.moshi.Json

data class GamesList(
    @Json(name="list_title")  val listTitle: String,

    val games: List<GameTile>
)