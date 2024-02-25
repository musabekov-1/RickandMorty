package com.example.rickandmorty.characters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.rickandmorty.data.model.Result
import com.example.rickandmorty.databinding.ItemMortyBinding

class MainAdapter(
    private val list:List<Result>
): Adapter<MainAdapter.MainViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(ItemMortyBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(list[position])
    }

    inner class MainViewHolder(private val binding:ItemMortyBinding) :ViewHolder(binding.root){
        fun bind(response: Result) {
            binding.tvCharacterName.text=response.name
            binding.tvExistence.text=response.status
            binding.tvSpecies.text=response.species
            binding.tvLocationInfo.text=response.location.name
            Glide.with(binding.imgCharacter).load(response.image).into(binding.imgCharacter)
        }
    }
}