package com.jasmeet.idealsofttask.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiMovieUtilities {

    fun getInstance():Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}

