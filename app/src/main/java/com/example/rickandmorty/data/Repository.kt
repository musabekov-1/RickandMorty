package com.example.rickandmorty.data

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.rickandmorty.data.model.Response
import retrofit2.Call
import retrofit2.Callback
import javax.inject.Inject

class Repository @Inject constructor(private val apiService: CartoonApiService) {
    private val characters = MutableLiveData<Response>()
    fun getCharacters(): MutableLiveData<Response> {
        apiService.getCharacters().enqueue(object : Callback<Response> {
            override fun onResponse(
                call: Call<Response>,
                response: retrofit2.Response<Response>
            ) {
                if (response.isSuccessful) {
                    response.body().let {
                        if (it != null) {
                            characters.postValue(it)
                        }
                    }
                }
            }
            override fun onFailure(call: Call<Response>, t: Throwable) {
                Log.e("onFailure", "${t.localizedMessage}")
            }
        })
        return characters
    }
}