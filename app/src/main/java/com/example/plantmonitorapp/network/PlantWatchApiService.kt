package com.example.plantmonitorapp.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL =
    "https://plantwatchers.onmicrosoft.com/ba03e8a4-d543-4d36-9d55-b639eadcb940"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface PlantWatchApiService {
    @GET("Plants/GetList")
    suspend fun getPlants(): List<PlantModel>
}

object PlantWatchApi {
    val retrofitService : PlantWatchApiService by lazy {
        retrofit.create(PlantWatchApiService::class.java) }
}