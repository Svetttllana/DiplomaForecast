package com.example.forecast_diploma.presentation.adapter

import android.net.Uri
import androidx.recyclerview.widget.RecyclerView
import com.example.forecast_diploma.databinding.CiryWeatherItemBinding
import com.example.forecast_diploma.di.model.WeatherModel
import com.squareup.picasso.Picasso

class ListWeatherViewHolder(

    private var viewBinding: CiryWeatherItemBinding,

    ) : RecyclerView.ViewHolder(viewBinding.root) {

    fun bind(weatherModel: WeatherModel) {

        viewBinding.tvDateandTime.text = weatherModel.time
        viewBinding.tvCondition.text = weatherModel.text
        viewBinding.CityName.text = weatherModel.name
        viewBinding.region.text = weatherModel.region
        viewBinding.tvTemperature.text = weatherModel.temp_c.toString()

        Picasso.get().load("https:" +weatherModel.icon).into(viewBinding.imageViewicon)

    }

}