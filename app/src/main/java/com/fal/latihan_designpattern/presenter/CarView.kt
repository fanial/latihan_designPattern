package com.fal.latihan_designpattern.presenter

import com.fal.latihan_designpattern.model.ResponseDataCarItem

interface CarView {
    fun onSuccess(pesan : String, car : List<ResponseDataCarItem>)
    fun onError(pesan: String)
}