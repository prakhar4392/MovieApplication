package com.example.movieapplication.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movieapplication.data.Result
import com.example.movieapplication.repository.MovieRepo
import org.koin.core.KoinComponent
import org.koin.core.inject

class MovieViewModel: ViewModel(),KoinComponent {

    val repo:MovieRepo by inject()

    val data:MutableLiveData<List<Result>> = MutableLiveData()


    fun getListOfMovies(){
        val response = repo.fetchMovies()
        data.value = response.results
    }
}