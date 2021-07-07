package com.example.myapplication.Repository

import com.example.myapplication.RetrofitService

class MainRepository(private val retrofitService: RetrofitService) {

 suspend fun getmovies() = retrofitService.get()







}