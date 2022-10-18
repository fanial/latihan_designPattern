package com.fal.latihan_designpattern.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.fal.latihan_designpattern.R
import com.fal.latihan_designpattern.databinding.ActivityMainBinding
import com.fal.latihan_designpattern.model.ResponseDataCarItem
import com.fal.latihan_designpattern.network.ApiClient
import com.fal.latihan_designpattern.presenter.CarPresenter
import com.fal.latihan_designpattern.presenter.CarView
import com.fal.latihan_designpattern.viewModel.CarViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), CarView{
    var _binding : ActivityMainBinding? = null
     val binding get() = _binding!!
    private lateinit var presenter: CarPresenter
    lateinit var viewModel: CarViewModel
    lateinit var adapter: CarAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = CarPresenter(this)
        presenter.getDataCar()
        /**
        viewModel = ViewModelProvider(this).get(CarViewModel::class.java)
        viewModel.callAllData()
        viewModel.allLiveData().observe(this, Observer {
            if (it != null){
                adapter = CarAdapter(it)
                binding.rvMain.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
                binding.rvMain.adapter = CarAdapter(it)
                adapter.notifyDataSetChanged()
            }
        })
        **/
    }

    override fun onSuccess(pesan: String, car : List<ResponseDataCarItem>) {
        binding.rvMain.layoutManager = LinearLayoutManager(this)
        binding.rvMain.adapter = CarAdapter(car)
    }

    override fun onError(pesan: String) {
        Toast.makeText(this, pesan, Toast.LENGTH_LONG).show()
    }

}