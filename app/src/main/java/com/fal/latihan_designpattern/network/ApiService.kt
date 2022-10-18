package com.fal.latihan_designpattern.network

import com.fal.latihan_designpattern.model.ResponseDataCarItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("admin/car")
    fun getCar() : Call<List<ResponseDataCarItem>>
}