package com.example.rickandmorty.data

import retrofit2.Call
import retrofit2.http.GET

interface CartoonApiService {
    @GET("character")
    fun getCharacters():Call<com.example.rickandmorty.data.model.Response>
}