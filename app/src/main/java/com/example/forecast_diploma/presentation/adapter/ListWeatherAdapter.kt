package com.example.forecast_diploma.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.forecast_diploma.databinding.CiryWeatherItemBinding
import com.example.forecast_diploma.presentation.model.WeatherModel

class ListWeatherAdapter(
    private val weatherListener: WeatherListener
) : RecyclerView.Adapter<ListWeatherViewHolder>() {

    private var listItems = mutableListOf<WeatherModel>()

    fun submitList(list: List<WeatherModel>) {
        this.listItems.clear()
        listItems.addAll(list.toMutableList())
        this.notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListWeatherViewHolder {

        val viewBinding =
            CiryWeatherItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListWeatherViewHolder(weatherListener,viewBinding)


    }

    override fun onBindViewHolder(holder: ListWeatherViewHolder, position: Int) {

        holder.bind(listItems[position])
    }

    override fun getItemCount(): Int {
        return listItems.size
    }
}