package com.example.forecast_diploma.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.forecast_diploma.databinding.FragmentCurrentWeatherBinding
import com.example.forecast_diploma.utils.Constans.C
import com.example.forecast_diploma.utils.Constans.COUNTRY
import com.example.forecast_diploma.utils.Constans.HUMIDITY
import com.example.forecast_diploma.utils.Constans.ICON
import com.example.forecast_diploma.utils.Constans.MAX_T
import com.example.forecast_diploma.utils.Constans.MIN_T
import com.example.forecast_diploma.utils.Constans.NAME
import com.example.forecast_diploma.utils.Constans.TEMP_C
import com.example.forecast_diploma.utils.Constans.TEXT
import com.example.forecast_diploma.utils.Constans.TIME
import com.example.forecast_diploma.utils.Constans.max
import com.example.forecast_diploma.utils.Constans.min
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

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

            binding.date.text = safeBundle.getString(ICON)
            binding.tvCityName.text = safeBundle.getString(NAME)
            binding.country.text = safeBundle.getString(COUNTRY)
            binding.condition.text = safeBundle.getString(TEXT)
            Picasso.get().load("https:" + safeBundle.getString(TIME)).into(binding.imWeatherIcon)
            binding.tempersture.text = safeBundle.getString(TEMP_C) + C
            binding.tvMaxT.text = max+ safeBundle.getString(MAX_T)
            binding.tvMinT.text = min+safeBundle.getString(MIN_T)
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
