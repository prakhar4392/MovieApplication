package com.example.movieapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapplication.adapter.MovieAdapter
import com.example.movieapplication.viewmodel.MovieViewModel

class MainActivity : AppCompatActivity() {

    lateinit var adapter:MovieAdapter

    lateinit var  rvMovies:RecyclerView
    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val layoutManager = LinearLayoutManager(this)
        adapter = MovieAdapter(arrayListOf())
        rvMovies = findViewById(R.id.rv_movies)
        rvMovies.layoutManager = layoutManager
        rvMovies.adapter = adapter
        val viewModel = ViewModelProvider(this).get(MovieViewModel::class.java)
        viewModel.getListOfMovies()
        viewModel.data.observe(this) {
             adapter = MovieAdapter(it)
             adapter.notifyDataSetChanged()
        }
    }
}