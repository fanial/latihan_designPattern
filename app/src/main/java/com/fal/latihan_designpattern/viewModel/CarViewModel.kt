package com.fal.latihan_designpattern.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fal.latihan_designpattern.model.ResponseDataCarItem
import com.fal.latihan_designpattern.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CarViewModel : ViewModel() {

    var allData : MutableLiveData<List<ResponseDataCarItem>?>

    init{
        allData = MutableLiveData()
    }

    fun allLiveData() : MutableLiveData<List<ResponseDataCarItem>?>{
        return allData
    }

    //retrofit
    fun callAllData(){
        ApiClient.instance.getCar()
            .enqueue(object : Callback<List<ResponseDataCarItem>>{
                override fun onResponse(
                    call: Call<List<ResponseDataCarItem>>,
                    response: Response<List<ResponseDataCarItem>>,
                ) {
                    if (response.isSuccessful){
                        allData.postValue(response.body()!!)
                    }else{
                        allData.postValue(null)
                    }
                }

                override fun onFailure(call: Call<List<ResponseDataCarItem>>, t: Throwable) {
                    allData.postValue(null)
                }

            })
    }
}