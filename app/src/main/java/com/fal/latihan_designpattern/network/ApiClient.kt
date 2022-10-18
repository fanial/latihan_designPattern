package com.fal.latihan_designpattern.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    const val BASE_URL = "https://rent-cars-api.herokuapp.com/"
    val instance : ApiService by lazy {
        val service = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
        service.create(ApiService::class.java)
    }
}