package com.example.forecast_diploma.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.forecast_diploma.R
import com.example.forecast_diploma.databinding.FragmentFavoriteBinding
import com.example.forecast_diploma.presentation.favAdapter.FavListener
import com.example.forecast_diploma.presentation.favAdapter.FavoriteAdapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class FavoriteFragment : Fragment(), FavListener {

    private var _binding: FragmentFavoriteBinding? = null
    private val binding: FragmentFavoriteBinding get() = _binding!!

    private lateinit var favAdapter: FavoriteAdapter
    private val viewModel: FavoriteViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoriteBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        favAdapter = FavoriteAdapter(this)

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter=favAdapter
        viewModel.getWeatherFavorites()

        viewModel.favorite.observe(viewLifecycleOwner){
            favAdapter.submitList(it)
        }

    }

    override fun onDeliteClicked(name: String) {
        viewModel.deleteFav(name)
    }


}