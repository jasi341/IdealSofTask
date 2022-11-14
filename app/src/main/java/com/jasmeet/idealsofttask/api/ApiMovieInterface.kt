package com.jasmeet.idealsofttask.api

import com.jasmeet.myapplication_1.models.Movies1
import retrofit2.Response
import retrofit2.http.GET

interface ApiMovieInterface {

    @GET("/3/movie/popular?api_key=13404d9c29034a2158f6566df6f9bd34&language=en-US&page=1")
    suspend fun getMovieData():Response<Movies1>
}