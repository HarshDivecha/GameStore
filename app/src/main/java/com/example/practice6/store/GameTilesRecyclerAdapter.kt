package com.example.practice6.store

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.practice6.R
import com.example.practice6.databinding.StoreGameTileBinding

class GameTilesRecyclerAdapter
    :ListAdapter<GameTile,GameTilesRecyclerAdapter.ViewHolder>(GameTileDiffUtil()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder private constructor(private val binding: StoreGameTileBinding)
        : RecyclerView.ViewHolder(binding.root){

        fun bind(gameTile: GameTile){
            binding.gameTitleTextview.text = gameTile.title
            val uri = gameTile.imgUrl.toUri().buildUpon().scheme("https").build()
            Glide.with(binding.gameImageImageview.context)
                .load(uri)
                .into(binding.gameImageImageview)
        }
        companion object{
            fun from(parent: ViewGroup): ViewHolder{
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding: StoreGameTileBinding = DataBindingUtil
                    .inflate(layoutInflater, R.layout.store_game_tile,parent,false)
                return ViewHolder(binding)
            }
        }
    }
}

class GameTileDiffUtil: DiffUtil.ItemCallback<GameTile>(){
    override fun areItemsTheSame(oldItem: GameTile, newItem: GameTile): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: GameTile, newItem: GameTile): Boolean {
        return oldItem.title == newItem.title
    }

}
