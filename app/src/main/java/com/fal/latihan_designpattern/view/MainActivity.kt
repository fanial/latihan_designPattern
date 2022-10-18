package com.fal.latihan_designpattern.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.fal.latihan_designpattern.databinding.ActivityMainBinding
import com.fal.latihan_designpattern.model.ResponseDataCarItem
import com.fal.latihan_designpattern.presenter.CarPresenter
import com.fal.latihan_designpattern.presenter.CarView

class MainActivity : AppCompatActivity(), CarView{
    var _binding : ActivityMainBinding? = null
     val binding get() = _binding!!
    private lateinit var presenter: CarPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = CarPresenter(this)
        presenter.getDataCar()
    }

    override fun onSuccess(pesan: String, car : List<ResponseDataCarItem>) {
        binding.rvMain.layoutManager = LinearLayoutManager(this)
        binding.rvMain.adapter = CarAdapter(car)
    }

    override fun onError(pesan: String) {
        Toast.makeText(this, pesan, Toast.LENGTH_LONG).show()
    }

}