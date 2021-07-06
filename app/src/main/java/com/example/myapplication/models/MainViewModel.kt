package com.example.myapplication.models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.Repository.MainRepository




// this class will Create the Object of viewmodel

class MainViewModel(val repository: MainRepository) :ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return  if (modelClass.isAssignableFrom(ViewModell::class.java)) {
           ViewModell(this.repository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}