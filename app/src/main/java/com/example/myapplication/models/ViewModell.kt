package com.example.myapplication.models

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.Repository.MainRepository
import retrofit2.Call
import retrofit2.Response


public class ViewModell constructor(private val repository: MainRepository)  : ViewModel() {

    // this line of code will create the list of  mutablelivedata<articles>
    val movieList = MutableLiveData<List<articles>>()


  

    // Function for Calling the get request
    fun getAllMovies() {
        val response = repository.getmovies()

       response.enqueue(object : retrofit2.Callback<Model>{
            override fun onResponse(call: Call<Model>, response: Response<Model>) {
                val data : Model? = response.body()
                if (data != null) {

                    Log.d("data is not there",response.body().toString())
                    movieList.postValue(data.articles)
                }

            }

            override fun onFailure(call: Call<Model>, t: Throwable) {
              Log.d("sahu","data nahi aa raha")

            }
        } )

    }



}

