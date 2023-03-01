package com.example.forecast_diploma.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.forecast_diploma.databinding.DaysItemBinding
import com.example.forecast_diploma.di.model.FutureWeatherModel
import com.squareup.picasso.Picasso

class DaysWeatherViewHolder(

    private var viewBinding: DaysItemBinding,

    ) : RecyclerView.ViewHolder(viewBinding.root) {

    fun bind(futureWeatherModel: FutureWeatherModel) {

        viewBinding.tvDateandTime.text = futureWeatherModel.date
        viewBinding.tvCondition.text = futureWeatherModel.text
        viewBinding.maxTemp.text = futureWeatherModel.maxtemp_c.toString()
        viewBinding.minTemp.text = futureWeatherModel.mintemp_c.toString()
        viewBinding.tvTemperature.text = futureWeatherModel.temp_c.toString()

        Picasso.get().load("https:" + futureWeatherModel.icon).into(viewBinding.imageViewicon)


    }

}