package com.example.forecast_diploma.presentation

import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.forecast_diploma.databinding.FragmentMainWeatherBinding
import com.example.forecast_diploma.di.model.WeatherModel
import com.example.forecast_diploma.presentation.adapter.ListWeatherAdapter
import com.squareup.picasso.Picasso


import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainWeatherFragment : Fragment() {

    private var _binding: FragmentMainWeatherBinding? = null
    private val binding: FragmentMainWeatherBinding get() = _binding!!
    private val viewModel: MainWeatherViewModel by viewModels()
    private lateinit var weatherAdapter: ListWeatherAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainWeatherBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getListWeather()


        weatherAdapter = ListWeatherAdapter()

        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter =weatherAdapter


        viewModel.currentWeather.observe(viewLifecycleOwner) { listItems ->
            weatherAdapter.submitList(listItems)
        }

        viewModel.bundle.observe(viewLifecycleOwner) { navBundle ->
            if (navBundle != null) {
                val bundle = Bundle()
                bundle.putString("time", navBundle.time)
                bundle.putString("name", navBundle.name)
                bundle.putString("country", navBundle.country)
                bundle.putString("region", navBundle.region)
                bundle.putString("text", navBundle.text)
                bundle.putString("temp_c", navBundle.temp_c.toString())
                bundle.putString("icon", navBundle.icon)
              //  Picasso.get().load(Uri.parse( navBundle.icon)).into(binding.imageWeather)
            }
          //  Picasso.get().load(Uri.parse( weatherModel.icon)).into(binding.imageViewicon)


            viewModel.currentWeather.observe(viewLifecycleOwner) {
//            it?.let { weather ->
//                binding. = weather.
//                binding.tvCondition.text = weather.text
//                binding.tvlocalTime.text = weather.localtime
//                binding.tvTemperature.text = weather.temp_c.toString()
//
//                Picasso.get().load("https:" + weather.icon).into(binding.imageWeather)
//            }
            }

//                viewModel.currentWeather.observe(viewLifecycleOwner){
//                    it.map {weathe ->
//
//                        binding.  //tvDateandTime.text = weather.time
//                        binding.tvCondition.text = weatherModel.text
//                        binding.CityName.text = weatherModel.name
//                        binding.region.text = weatherModel.region
//                        binding.tvTemperature.text = weatherModel.temp_c.toString()
//
//
//                    }
//                }

        }
    }
}


