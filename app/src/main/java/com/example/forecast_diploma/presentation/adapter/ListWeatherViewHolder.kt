package com.example.forecast_diploma.presentation.adapter

import android.annotation.SuppressLint
import android.net.Uri
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.forecast_diploma.databinding.CiryWeatherItemBinding
import com.example.forecast_diploma.presentation.model.WeatherModel
import com.example.forecast_diploma.utils.Constans.C
import com.squareup.picasso.Picasso

class ListWeatherViewHolder(
    private var weatherListener: WeatherListener,
    private var viewBinding: CiryWeatherItemBinding,
    ) : RecyclerView.ViewHolder(viewBinding.root) {

    @SuppressLint("SetTextI18n")
    fun bind(weatherModel: WeatherModel) {
        viewBinding.tvDateandTime.text = weatherModel.time
        viewBinding.tvCondition.text = weatherModel.text
        viewBinding.CityName.text = weatherModel.name
        viewBinding.tvTemperature.text = weatherModel.temp_c.toString()+C

        Picasso.get().load("https:" + weatherModel.icon).into(viewBinding.imageViewicon)

        itemView.setOnClickListener {
            weatherListener.onElementClick(
                weatherModel.name,
                weatherModel.region,
                weatherModel.country,
                weatherModel.temp_c,
                weatherModel.text,
                weatherModel.time,
                weatherModel.icon,
                weatherModel.max_t,
                weatherModel.min_t,
                weatherModel.humidity
            )
        }
    }
}

