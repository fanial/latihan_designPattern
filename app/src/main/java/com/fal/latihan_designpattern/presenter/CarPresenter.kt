package com.fal.latihan_designpattern.presenter

import com.fal.latihan_designpattern.model.ResponseDataCarItem
import com.fal.latihan_designpattern.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CarPresenter(val viewCar : CarView) {

    fun getDataCar(){
        ApiClient.instance.getCar()
            .enqueue(object : Callback<List<ResponseDataCarItem>>{
                override fun onResponse(
                    call: Call<List<ResponseDataCarItem>>,
                    response: Response<List<ResponseDataCarItem>>,
                ) {
                    if (response.isSuccessful){
                        viewCar.onSuccess(response.message(), response.body()!!)
                    }else{
                        viewCar.onError(response.message())
                    }
                }

                override fun onFailure(call: Call<List<ResponseDataCarItem>>, t: Throwable) {
                    viewCar.onError(t.message!!)
                }

            })
    }

}