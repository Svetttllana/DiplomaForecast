package com.example.forecast_diploma.presentation.favAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.forecast_diploma.databinding.ItemFavoriteBinding
import com.example.forecast_diploma.presentation.model.FavoriteModel

class FavoriteAdapter(
    private var favListener:FavListener
) : RecyclerView.Adapter<FavoriteViewHolder>() {

    private var listItems = mutableListOf<FavoriteModel>()

    fun submitList(list: List<FavoriteModel>) {
        this.listItems.clear()
        listItems.addAll(list.toMutableList())
        this.notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {

        val viewBinding =
            ItemFavoriteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoriteViewHolder(favListener,viewBinding)


    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {

        holder.bind(listItems[position])
    }

    override fun getItemCount(): Int {
        return listItems.size
    }
}
