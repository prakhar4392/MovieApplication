package com.example.movieapplication.di

import com.example.movieapplication.repository.MovieRepo
import org.koin.dsl.module

val appModule = module {
    single { MovieRepo(get()) }
}