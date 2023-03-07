package com.example.forecast_diploma.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.forecast_diploma.R
import com.example.forecast_diploma.databinding.FragmentDaysWeatherBinding
import com.example.forecast_diploma.databinding.FragmentMainWeatherBinding
import com.example.forecast_diploma.di.model.FutureWeatherModel
import com.example.forecast_diploma.di.model.WeatherModel
import com.example.forecast_diploma.presentation.adapter.DaysWeatherAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DaysWeatherFragment : Fragment() {

    private var _binding: FragmentDaysWeatherBinding? = null
    private val binding: FragmentDaysWeatherBinding get() = _binding!!
    private lateinit var daysAdapter: DaysWeatherAdapter
    private val viewModel: DaysWeatherViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentDaysWeatherBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        daysAdapter = DaysWeatherAdapter()
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = daysAdapter

//viewModel.getForecastData()
//    viewModel.days.observe(viewLifecycleOwner){
//        daysAdapter.submitList(it as List<FutureWeatherModel>)
//    }
    }
}