package com.fal.latihan_designpattern.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fal.latihan_designpattern.databinding.ItemListBinding
import com.fal.latihan_designpattern.model.ResponseDataCarItem

class CarAdapter(var itemCar : List<ResponseDataCarItem>) : RecyclerView.Adapter<CarAdapter.ViewHolder>(){
    class ViewHolder (val binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.vNameCar.text = itemCar[position].name
        holder.binding.vHarga.text = itemCar[position].price.toString()
        Glide.with(holder.itemView).load(itemCar[position].image).into(holder.binding.vImage)
    }

    override fun getItemCount(): Int {
        return itemCar.size
    }
}