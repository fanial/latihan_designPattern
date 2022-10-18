package com.fal.latihan_designpattern.view

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.fal.latihan_designpattern.databinding.ActivityMainBinding
import com.fal.latihan_designpattern.viewModel.CarViewModel

class MainActivity : AppCompatActivity(){
    private var _binding : ActivityMainBinding? = null
    private val binding get() = _binding!!
    lateinit var viewModel: CarViewModel
    lateinit var adapter: CarAdapter

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(CarViewModel::class.java)
        viewModel.callAllData()
        viewModel.allLiveData().observe(this) {
            if (it != null) {
                adapter = CarAdapter(it)
                binding.rvMain.layoutManager =
                    LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
                binding.rvMain.adapter = CarAdapter(it)
                adapter.notifyDataSetChanged()
            }
        }
    }
}