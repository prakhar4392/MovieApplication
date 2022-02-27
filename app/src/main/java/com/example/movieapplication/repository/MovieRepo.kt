package com.example.movieapplication.repository

import android.content.Context
import com.example.movieapplication.data.MovieDetailsDto
import com.google.gson.Gson
import org.json.JSONObject
import org.koin.dsl.koinApplication
import java.io.IOException
import java.io.InputStream

class MovieRepo(private val context:Context) {


    fun loadJSONFromAsset(): String? {
        var json: String? = null
        json = try {
            val `is`: InputStream = context.getAssets().open("movieData.json")
            val size: Int = `is`.available()
            val buffer = ByteArray(size)
            `is`.read(buffer)
            `is`.close()
            String(buffer)
        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }
        return json
    }

    fun fetchMovies():MovieDetailsDto {

        val jsonObject = JSONObject(loadJSONFromAsset())

        val response = Gson().fromJson(Gson().toJson(jsonObject),MovieDetailsDto::class.java)

        return response

    }

}