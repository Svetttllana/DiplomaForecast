package com.example.forecast_diploma.presentation.favAdapter

import androidx.recyclerview.widget.RecyclerView
import com.example.forecast_diploma.databinding.ItemFavoriteBinding
import com.example.forecast_diploma.presentation.model.FavoriteModel
import com.example.forecast_diploma.utils.Constans.C
import com.squareup.picasso.Picasso


class FavoriteViewHolder(
    private var favListener:FavListener,
    private var binding: ItemFavoriteBinding
) : RecyclerView.ViewHolder(binding.root) {


    fun bind(favModel: FavoriteModel) {
        binding.tvTemperature.text = favModel.temp_c.toString() + C
        binding.CityName.text = favModel.name
        binding.tvCondition.text = favModel.text
        Picasso.get().load("https:"+favModel.icon).into(binding.imageViewicon)



      binding.deliteFav.setOnClickListener{
          favListener.onDeliteClicked(favModel.name)
      }

    }

}




