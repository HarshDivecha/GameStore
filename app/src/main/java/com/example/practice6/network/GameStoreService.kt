package com.example.practice6.network

import com.example.practice6.store.GamesList
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

const val BASE_URL="https://firestore-apis.herokuapp.com/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface GameStoreService {
    @GET("tr2")
    suspend fun getGameStore(): List<GamesList>
}

object GameStoreApi{
    val gameStoreService: GameStoreService = retrofit.create(GameStoreService::class.java)
}