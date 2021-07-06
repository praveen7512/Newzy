package com.example.myapplication

import com.example.myapplication.models.Model
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


const val apikey = "95b6d8836ab74b2386fe24441682c94f"
interface RetrofitService {




    @GET("v2/top-headlines?country=in&category=business&apiKey=$apikey")
    fun get() :Call<Model>


    companion object {

        var retrofitService: RetrofitService? = null

        fun getInstance() : RetrofitService {

            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://newsapi.org/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(RetrofitService::class.java)
            }
            return retrofitService!!
        }
    }
}