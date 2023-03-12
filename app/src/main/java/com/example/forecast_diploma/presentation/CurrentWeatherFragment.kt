package com.example.forecast_diploma.presentation

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.forecast_diploma.databinding.FragmentCurrentWeatherBinding
import com.example.forecast_diploma.presentation.model.WeatherModel
import com.example.forecast_diploma.utils.Constans.C
import com.example.forecast_diploma.utils.Constans.COUNTRY
import com.example.forecast_diploma.utils.Constans.HUMIDITY
import com.example.forecast_diploma.utils.Constans.ICON
import com.example.forecast_diploma.utils.Constans.MAX_T
import com.example.forecast_diploma.utils.Constans.MIN_T
import com.example.forecast_diploma.utils.Constans.NAME
import com.example.forecast_diploma.utils.Constans.REGION
import com.example.forecast_diploma.utils.Constans.TEMP_C
import com.example.forecast_diploma.utils.Constans.TEXT
import com.example.forecast_diploma.utils.Constans.TIME
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.http.Url

@AndroidEntryPoint
class CurrentWeatherFragment() : Fragment() {

    private var _binding: FragmentCurrentWeatherBinding? = null
    private val binding: FragmentCurrentWeatherBinding get() = _binding!!
    private val viewModel: CurrentWeatherViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCurrentWeatherBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bundle = arguments

        bundle?.let { safeBundle ->

            binding.date.text = safeBundle.getString(TIME)
            binding.tvCityName.text = safeBundle.getString(NAME)
            binding.country.text = safeBundle.getString(COUNTRY)
            binding.condition.text = safeBundle.getString(TEXT)
            val icon = safeBundle.getString(ICON)
            Picasso.get().load("https:" + safeBundle.getString(ICON)).into(binding.imWeatherIcon)
            binding.tempersture.text = safeBundle.getString(TEMP_C) + C
            binding.tvMaxMin.text = safeBundle.getString("Max:${MAX_T}/" + "Main: ${MIN_T}")
            binding.tvHumidity.text = safeBundle.getString(HUMIDITY)

            val name = safeBundle.getString(NAME)
            binding.tvCityName.text = name


            binding.btnFav.setOnClickListener {
                binding.btnFav.isSelected = !it.isSelected
                if (name != null) {
                    viewModel.onFavClicked(name)

                }
            }
        }

    }
}
