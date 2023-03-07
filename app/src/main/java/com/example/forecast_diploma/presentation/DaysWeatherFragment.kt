package com.example.forecast_diploma.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.forecast_diploma.databinding.FragmentDaysWeatherBinding
import com.example.forecast_diploma.presentation.adapter.ListWeatherAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DaysWeatherFragment : Fragment() {

    private var _binding: FragmentDaysWeatherBinding? = null
    private val binding: FragmentDaysWeatherBinding get() = _binding!!

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



//viewModel.getForecastData()
//    viewModel.days.observe(viewLifecycleOwner){
//        daysAdapter.submitList(it as List<FutureWeatherModel>)
//    }
    }
}