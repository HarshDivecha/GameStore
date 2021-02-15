package com.example.practice6.store

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.practice6.R
import com.example.practice6.databinding.StoreFragmentBinding

class Store : Fragment() {

    private lateinit var binding: StoreFragmentBinding

    private lateinit var viewModel: StoreViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.store_fragment, container, false)
        viewModel = ViewModelProvider(this).get(StoreViewModel::class.java)
        
        val adapter = GameListRecyclerAdapter()
        binding.gameStoreRecycler.adapter = adapter
        viewModel.gamesList.observe(viewLifecycleOwner,{
            it?.let {
                adapter.submitList(it)
            }
        })
        
        return binding.root
    }


}