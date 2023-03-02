package com.example.forecast_diploma.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.forecast_diploma.databinding.DaysItemBinding
import com.example.forecast_diploma.di.model.FutureWeatherModel

class DaysWeatherAdapter(

) : RecyclerView.Adapter<DaysWeatherViewHolder>() {

    private var listItems = mutableListOf<FutureWeatherModel>()

    fun submitList(list: List<FutureWeatherModel>) {
        this.listItems.clear()
        listItems.addAll(list.toMutableList())
        this.notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DaysWeatherViewHolder {

        val viewBinding =
            DaysItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DaysWeatherViewHolder(viewBinding)


    }

    override fun onBindViewHolder(holder: DaysWeatherViewHolder, position: Int) {

        holder.bind(listItems[position])
    }

    override fun getItemCount(): Int {
        return listItems.size
    }
}