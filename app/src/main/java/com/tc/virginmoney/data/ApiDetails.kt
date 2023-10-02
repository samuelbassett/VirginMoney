package com.tc.virginmoney.data

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create


object ApiDetails {
    const val baseURL = "https://61e947967bc0550017bc61bf.mockapi.io/api/v1/"
    const val PEOPLE_ENDPOINT = "people"
    const val ROOMS_ENDPOINT = "rooms"

    val retrofit =  Retrofit.Builder()
        .baseUrl(baseURL)
        .client(OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)).build())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val service = retrofit.create(ApiEndpoint::class.java)
}