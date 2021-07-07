package com.example.myapplication.models

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.Repository.MainRepository
import kotlinx.coroutines.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response


public class ViewModell constructor(private val repository: MainRepository)  : ViewModel() {

    // this line of code will create the list of  mutablelivedata<articles>
    val movieList = MutableLiveData<List<articles>>()
    val errorMessage = MutableLiveData<String>()





    var job: Job? = null
    val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        onError("Exception handled: ${throwable.localizedMessage}")
    }
    val loading = MutableLiveData<Boolean>()

    fun getAllMovies() {
        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            val response  = repository.getmovies()
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    movieList.postValue(response.body()?.articles)
                    loading.value = false
                } else {
                    onError("Error : ${response.message()} ")
                }
            }
        }

    }

    private fun onError(message: String) {
        errorMessage.value = message
        loading.value = false
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }



}

