package com.example.practice6.store

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.practice6.R
import com.example.practice6.databinding.StoreGameListBinding

class GameListRecyclerAdapter
    : ListAdapter<GamesList, GameListRecyclerAdapter.ViewHolder>(GameListDiffUtil()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder private constructor(private val binding: StoreGameListBinding)
        : RecyclerView.ViewHolder(binding.root){

        fun bind(gamesList: GamesList){
            val adapter = GameTilesRecyclerAdapter()
            adapter.submitList(gamesList.games)
            binding.gamesListRecycler.adapter = adapter
            binding.gamesListTitle.text = gamesList.listTitle
        }
        companion object{
            fun from(parent: ViewGroup): ViewHolder{
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding: StoreGameListBinding = DataBindingUtil
                    .inflate(layoutInflater, R.layout.store_game_list,parent,false)
                return ViewHolder(binding)
            }
        }
    }
}

class GameListDiffUtil: DiffUtil.ItemCallback<GamesList>(){
    override fun areItemsTheSame(oldItem: GamesList, newItem: GamesList): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: GamesList, newItem: GamesList): Boolean {
        return oldItem.listTitle == newItem.listTitle
    }
}
