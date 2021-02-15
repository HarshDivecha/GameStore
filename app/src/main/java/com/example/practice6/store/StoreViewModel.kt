package com.example.practice6.store

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practice6.network.GameStoreApi
import kotlinx.coroutines.launch
import timber.log.Timber

class StoreViewModel : ViewModel() {

    private val _gamesList = MutableLiveData<List<GamesList>>()
    val gamesList: LiveData<List<GamesList>> get() = _gamesList

    init {
        getGamesList()
    }

    private fun getGamesList() {
        viewModelScope.launch {
            _gamesList.value = GameStoreApi.gameStoreService.getGameStore()
            Timber.e(_gamesList.value.toString())
        }
    }
}