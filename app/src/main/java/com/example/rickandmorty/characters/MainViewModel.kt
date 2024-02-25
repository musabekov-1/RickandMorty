package com.example.rickandmorty.characters

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.rickandmorty.data.Repository
import com.example.rickandmorty.data.model.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val reposity:Repository):ViewModel() {
    fun getCharacters():LiveData<Response> = reposity.getCharacters()
}